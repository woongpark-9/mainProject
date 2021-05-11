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
      //POST������� ��û�Ҷ� ����ϴ� ���̺귯�� key=value�����͸� ��û (īī���� ��û)
      RestTemplate rt = new RestTemplate();
      //http��� ��ü ����
      HttpHeaders headers = new HttpHeaders();
      //������ Ÿ�� �߰� key=value�������� ��Ŵ�
      headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
      //body�����͸� ���� ��ü
      MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
      params.add("grant_type", "authorization_code");
      params.add("client_id", "6282ec2ffbb4c314d17b7d5478824418");
      params.add("redirect_uri", "ec2-18-221-64-44.us-east-2.compute.amazonaws.com:8080/nowflix/kakaoController.do");
      params.add("code", code);
      // �ٵ�� ����� ���� ��ƼƼ����
      HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
            new HttpEntity<>(params,headers);
      
      // ���� : ��ū�߱޿�û�ּ� , post���� , �ʼ���û������ , ������ ���� Ÿ�� 
      ResponseEntity<String> response = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest,
            String.class);
      //json�� �ڹٰ�ü�� ����
      ObjectMapper objectMapper = new ObjectMapper();
      OAuthToken oauthToken = null;
      try {
         oauthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("������� �ڵ� : "+code);
      System.out.println("īī�� �׼��� ��ū : " + oauthToken.getAccess_token());
      System.out.println("��ū ��û �Ϸ� ��ū��û�� ���� ���� : "+response);
      
      
      //POST������� ��û�Ҷ� ����ϴ� ���̺귯�� key=value�����͸� ��û (īī���� ��û)
      RestTemplate rt2 = new RestTemplate();
      //http��� ��ü ����
      HttpHeaders headers2 = new HttpHeaders();
      headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
      //������ Ÿ�� �߰� key=value�������� ��Ŵ�
      headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
      
      // �ٵ�� ����� ���� ��ƼƼ����
      HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
            new HttpEntity<>(headers2);
      
      // ���� : �����ʹ߱޿�û�ּ� , post���� , �ʼ���û������ , ������ ���� Ÿ�� 
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
      
      System.out.println("īī�� ���̵�(��ȣ) : "+kakaoProfile.getId());
      System.out.println("īī�� �̸��� :"+kakaoProfile.getKakao_account().getEmail());
       
      System.out.println("�����ø��� �������� : "+kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
      System.out.println("�����ø��� �̸��� : "+kakaoProfile.getKakao_account().getEmail());
      System.out.println("�̸� : "+kakaoProfile.getKakao_account().getProfile().getNickname());
      MemberVO member = new MemberVO();
      
   
      member.setEmail(kakaoProfile.getKakao_account().getEmail());
      member.setNickname(kakaoProfile.getKakao_account().getProfile().getNickname());
      
      session.setAttribute("member", member);
   
      MemberVO login = service.login(member);
      if(login == null) {
         member.setKakao(Integer.toString(kakaoProfile.getId()));
         // �ű�ȸ���̶�� ������������
         System.out.println("īī�� �ű�ȸ���Դϴ�");
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
            System.out.println("�ش� ������ �̿�� : "+ticketCheck);
            // �帣�� �����ߴ��� Ȯ��
            String genreCheck = service.genreCheck(login);
            System.out.println(genreCheck);
            if(genreCheck.equals("N")) {
               System.out.println("�帣�������� �̵��մϴ�");
                     page = "redirect:favorite.do";
               return page;
            }
            // �帣�� �����ߴٸ� ������ ��������
            ScriptUtils.alert(resp, "īī�� �α��� �����Ǿ����ϴ�");
            page = "forward:profile.do";
            return page;
         }
         System.out.println("īī�� ����ȸ���Դϴ� �α��� ó��");
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
         System.out.println("�ش� ������ �̿�� : "+ticketCheck);
         // �帣�� �����ߴ��� Ȯ��
         String genreCheck = service.genreCheck(login);
         System.out.println(genreCheck);
         if(genreCheck.equals("N")) {
            System.out.println("�帣�������� �̵��մϴ�");
                  page = "redirect:favorite.do";
            return page;
         }
         // �帣�� �����ߴٸ� ������ ��������
         
      }
      page = "redirect:profile.do";
      return page;
      
      // ���� �����ø��� ������ �̿��� ȸ������
      // User user = new User();
      // user.setName(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
      // user.setEmail(kakaoProfile.getKakao_account().getEmail());
      // user.setPassword(tempuuid);
      
      //
      
      // ������ Ȥ�� ������ üũ�ؼ� ó��
      // User originUser = userService.getUser(user);
      // if(originUser == null){
      //   System.out.println("�ű�ȸ���Դϴ�");
      //  userService.ȸ������(user);
      // }
      
      // �α���ó��
      
      
   }
   
   }
   
