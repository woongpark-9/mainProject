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
      // 1. code�� �̿��ؼ� access_token �ޱ�
      // 2. access_token�� �̿��ؼ� ����� profile ���� ��������

      SNSLogin snsLogin = new SNSLogin(naverSns);
      // String profile = snsLogin.getUserProfile(code);
      MemberVO member = snsLogin.getMemberProfile(code);

      System.out.println("Profile>>" + member);
//      model.addAttribute("result", snsMember);
      // 3. DB �ش� ������ �����ϴ� üũ (googleid, naverid �÷� �߰�)

      // 4. ����� �����α���, ������� ������������ !!
      
      int result = service.oauthEmailCheck(member);
      session.setAttribute("member", member);
      MemberVO login = service.login(member);
      if(login == null) {
         // �ű�ȸ���̶�� �帣���� ��������
         System.out.println("���̹� �ű�ȸ���Դϴ�");
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
         //������ ���� ��������
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
         System.out.println("�ش� ������ �̿�� : "+ticketCheck);
         // �帣�� �����ߴ��� Ȯ��
         String genreCheck = service.genreCheck(member);
         System.out.println(genreCheck);
         if(genreCheck.equals("N")) {
            System.out.println("�帣�������� �̵��մϴ�");
                  page = "redirect:favorite.do";
            return page;
         }
         // �帣�� �����ߴٸ� ������ ��������
         
      
      ScriptUtils.alert(resp, "���̹� �α��� �����Ǿ����ϴ�");
      page = "forward:profile.do";
      return page;
      }
      System.out.println("���̹� ����ȸ���Դϴ� �α��� ó��");
   
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
      System.out.println("�ش� ������ �̿�� : "+ticketCheck);
      // �帣�� �����ߴ��� Ȯ��
      String genreCheck = service.genreCheck(member);
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

