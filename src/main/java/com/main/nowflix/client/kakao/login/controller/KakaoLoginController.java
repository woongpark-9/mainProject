package com.main.nowflix.client.kakao.login.controller;




import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.nowflix.client.kakao.login.token.KakaoProfile;
import com.main.nowflix.client.kakao.login.token.OAuthToken;
import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.ticket.service.TicketService;
import com.main.nowflix.client.ticket.vo.TicketVO;
import com.main.nowflix.util.ScriptUtils;

@Controller
public class KakaoLoginController {
   

   @Inject
   MemberService service;
   
   @Autowired
   TicketService ticketService;
   
   
   
   
   @RequestMapping("/kakaoController.do")
   public String kakaoCallback(String code,Model model,HttpSession session,HttpServletResponse resp) throws Exception  { // 
      String page = "";
      //POST방식으로 요청할때 사용하는 라이브러리 key=value데이터를 요청 (카카오로 요청)
      RestTemplate rt = new RestTemplate();
      //http헤더 객체 생성
      HttpHeaders headers = new HttpHeaders();
      //컨텐츠 타입 추가 key=value형식으로 쏠거다
      headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
      //body데이터를 담을 객체
      MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
      params.add("grant_type", "authorization_code");
      params.add("client_id", "6282ec2ffbb4c314d17b7d5478824418");
      params.add("redirect_uri", "ec2-18-221-64-44.us-east-2.compute.amazonaws.com:8080/nowflix/kakaoController.do");
      params.add("code", code);
      // 바디와 헤더를 가진 엔티티생성
      HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
            new HttpEntity<>(params,headers);
      
      // 응답 : 토큰발급요청주소 , post형태 , 필수요청데이터 , 응답을 받을 타입 
      ResponseEntity<String> response = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest,
            String.class);
      //json을 자바객체에 저장
      ObjectMapper objectMapper = new ObjectMapper();
      OAuthToken oauthToken = null;
      try {
         oauthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("응답받은 코드 : "+code);
      System.out.println("카카오 액세스 토큰 : " + oauthToken.getAccess_token());
      System.out.println("토큰 요청 완료 토큰요청에 대한 응답 : "+response);
      
      
      //POST방식으로 요청할때 사용하는 라이브러리 key=value데이터를 요청 (카카오로 요청)
      RestTemplate rt2 = new RestTemplate();
      //http헤더 객체 생성
      HttpHeaders headers2 = new HttpHeaders();
      headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
      //컨텐츠 타입 추가 key=value형식으로 쏠거다
      headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
      
      // 바디와 헤더를 가진 엔티티생성
      HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
            new HttpEntity<>(headers2);
      
      // 응답 : 프로필발급요청주소 , post형태 , 필수요청데이터 , 응답을 받을 타입 
      ResponseEntity<String> response2 = rt2.exchange(
            "https://kapi.kakao.com/v2/user/me",
            HttpMethod.POST,
            kakaoProfileRequest,
            String.class);
      
   
      
      ObjectMapper objectMapper2= new ObjectMapper();
      KakaoProfile kakaoProfile = null;
      try {
         kakaoProfile = objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      System.out.println("카카오 아이디(번호) : "+kakaoProfile.getId());
      System.out.println("카카오 이메일 :"+kakaoProfile.getKakao_account().getEmail());
       
      System.out.println("나우플릭스 유저네임 : "+kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
      System.out.println("나우플릭스 이메일 : "+kakaoProfile.getKakao_account().getEmail());
      System.out.println("이름 : "+kakaoProfile.getKakao_account().getProfile().getNickname());
      MemberVO member = new MemberVO();
      
   
      member.setEmail(kakaoProfile.getKakao_account().getEmail());
      member.setNickname(kakaoProfile.getKakao_account().getProfile().getNickname());
      
      session.setAttribute("member", member);
   
      MemberVO login = service.login(member);
      if(login == null) {
         member.setKakao(Integer.toString(kakaoProfile.getId()));
         // 신규회원이라면 결제페이지로
         System.out.println("카카오 신규회원입니다");
         service.oauthRegister(member);
         List<TicketVO> basicticketList = new ArrayList<TicketVO>();
         List<TicketVO> premiumticketList = new ArrayList<TicketVO>();
         basicticketList = ticketService.getTicketList(new TicketVO("basic"));
         premiumticketList = ticketService.getTicketList(new TicketVO("premium"));
         model.addAttribute("basicticketList",basicticketList);
         model.addAttribute("premiumticketList",premiumticketList);
         page = "views/member/selectTicket";
         return page;
         
      }else{
         if(login.getKakao() == null) {
            login.setKakao(Integer.toString(kakaoProfile.getId()));
            service.kakaoConnect(login);
            String ticketCheck = service.ticketCheck(login);
            if(ticketCheck.equals("N")) {
               List<TicketVO> basicticketList = new ArrayList<TicketVO>();
               List<TicketVO> premiumticketList = new ArrayList<TicketVO>();
               basicticketList = ticketService.getTicketList(new TicketVO("basic"));
               premiumticketList = ticketService.getTicketList(new TicketVO("premium"));
               model.addAttribute("basicticketList",basicticketList);
               model.addAttribute("premiumticketList",premiumticketList);
               page = "views/member/selectTicket";
               return page;
            } 
            System.out.println("해당 유저의 이용권 : "+ticketCheck);
            // 장르를 선택했는지 확인
            String genreCheck = service.genreCheck(login);
            System.out.println(genreCheck);
            if(genreCheck.equals("N")) {
               System.out.println("장르페이지로 이동합니다");
                     page = "redirect:favorite.do";
               return page;
            }
            // 장르를 선택했다면 프로필 페이지로
            ScriptUtils.alert(resp, "카카오 로그인 연동되었습니다");
            page = "forward:profile.do";
            return page;
         }
         System.out.println("카카오 기존회원입니다 로그인 처리");
         String ticketCheck = service.ticketCheck(login);
         if(ticketCheck.equals("N")) {
            List<TicketVO> basicticketList = new ArrayList<TicketVO>();
            List<TicketVO> premiumticketList = new ArrayList<TicketVO>();
            basicticketList = ticketService.getTicketList(new TicketVO("basic"));
            premiumticketList = ticketService.getTicketList(new TicketVO("premium"));
            model.addAttribute("basicticketList",basicticketList);
            model.addAttribute("premiumticketList",premiumticketList);
            page = "views/member/selectTicket";
            return page;
         }
         System.out.println("해당 유저의 이용권 : "+ticketCheck);
         // 장르를 선택했는지 확인
         String genreCheck = service.genreCheck(login);
         System.out.println(genreCheck);
         if(genreCheck.equals("N")) {
            System.out.println("장르페이지로 이동합니다");
                  page = "redirect:favorite.do";
            return page;
         }
         // 장르를 선택했다면 프로필 페이지로
         
      }
      page = "redirect:profile.do";
      return page;
      
      // 만든 나우플릭스 정보를 이용해 회원가입
      // User user = new User();
      // user.setName(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
      // user.setEmail(kakaoProfile.getKakao_account().getEmail());
      // user.setPassword(tempuuid);
      
      //
      
      // 가입자 혹은 비가입자 체크해서 처리
      // User originUser = userService.getUser(user);
      // if(originUser == null){
      //   System.out.println("신규회원입니다");
      //  userService.회원가입(user);
      // }
      
      // 로그인처리
      
      
   }
   
   }
   
