package com.main.nowflix.client.login.auth;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.ticket.service.TicketService;
import com.main.nowflix.client.ticket.vo.TicketVO;
import com.main.nowflix.util.ScriptUtils;

@Controller
public class SnsController {

   @Autowired
   private SnsValue naverSns;

   @Inject
   MemberService service;
   
   @Inject
   TicketService ticketService;


   @RequestMapping(value = "callbackNaver.do")
   public String snsNaverLoginCallback(Model model, @RequestParam String code,HttpSession session,HttpServletResponse resp) throws Exception {
      String page = "";
      // 1. code를 이용해서 access_token 받기
      // 2. access_token을 이용해서 사용자 profile 정보 가져오기

      SNSLogin snsLogin = new SNSLogin(naverSns);
      // String profile = snsLogin.getUserProfile(code);
      MemberVO member = snsLogin.getMemberProfile(code);

      System.out.println("Profile>>" + member);
//      model.addAttribute("result", snsMember);
      // 3. DB 해당 유저가 존재하는 체크 (googleid, naverid 컬럼 추가)

      // 4. 존재시 강제로그인, 미존재시 가입페이지로 !!
      
      int result = service.oauthEmailCheck(member);
      session.setAttribute("member", member);
      MemberVO login = service.login(member);
      if(login == null) {
         // 신규회원이라면 장르선택 페이지로
         System.out.println("네이버 신규회원입니다");
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
         if(login.getNaver() == null) {
         //프로필 선택 페이지로
         login.setNaver(member.getNaver());
         service.naverConnect(login);
         String ticketCheck = service.ticketCheck(member);
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
         String genreCheck = service.genreCheck(member);
         System.out.println(genreCheck);
         if(genreCheck.equals("N")) {
            System.out.println("장르페이지로 이동합니다");
                  page = "redirect:favorite.do";
            return page;
         }
         // 장르를 선택했다면 프로필 페이지로
         
      
      ScriptUtils.alert(resp, "네이버 로그인 연동되었습니다");
      page = "forward:profile.do";
      return page;
      }
      System.out.println("네이버 기존회원입니다 로그인 처리");
   
      String ticketCheck = service.ticketCheck(member);
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
      String genreCheck = service.genreCheck(member);
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
   }
   
}

   
//   @RequestMapping("/naverLogin.do")
//   public String login(Model model) throws Exception {
//
//   
//   
//
//      return "login/login";
//   }

