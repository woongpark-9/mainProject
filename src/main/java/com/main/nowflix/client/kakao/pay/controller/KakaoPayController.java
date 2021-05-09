package com.main.nowflix.client.kakao.pay.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.admin.sales.service.AdminSalesService;
import com.main.nowflix.admin.sales.vo.AdminSalesVO;
import com.main.nowflix.client.kakao.pay.service.KakaoPayService;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayApprovalVO;
import com.main.nowflix.client.kakao.pay.vo.KakaoPayCancelVO;
import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.sales.service.SalesService;
import com.main.nowflix.client.sales.vo.SalesVO;




@SessionAttributes("member")
@Controller
public class KakaoPayController {
   @Autowired
   private KakaoPayService kakaopay;
   
   // 사용자가 구매하려는 티켓아이디
   private String ticket_id;
   
   // 결제정보를 받을 vo객체
   private KakaoPayApprovalVO kakaoPayApprovalVO;
   
   @Autowired
   private SalesService service;
   
   @Autowired
   private MemberService memberService;
   
   private MemberVO member;
   
   private  SalesVO sales;
   
   // /kakaoPay get방식
   @GetMapping("/kakaoPay.do")
   public void kakaoPayGet() {
      
   }
   // /kakaoPay post방식
   @PostMapping("/kakaoPay.do")
   public String kakaoPay(String total_amount,String item_name,String ticket_id,Model model,HttpSession session) {
      // 결제고유번호,범용고유식별자(universally unique identifier)를 만들어내는 UUID 클래스 사용
      String partner_order_id = UUID.randomUUID().toString();
      // 현재 결제하려는 사용자가 누구인지 세션으로  member이름으로 바인딩된 객체를 가져온다 
      member = (MemberVO) session.getAttribute("member");
      System.out.println("접속한 사람 : "+member.getEmail()); 
      // 결제하려는 티켓아이디
      this.ticket_id = ticket_id;
      // 결제하려는 사람
      String partner_user_id = member.getEmail();
      
      // 결제준비로 이동
      return "redirect:" +kakaopay.kakaopayReady(total_amount,item_name,model,partner_order_id,partner_user_id);
    }
   
   @GetMapping("/kakaoPaySuccess.do")
   public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model,HttpServletRequest request,HttpSession session) throws Exception {
      System.out.println("kakaoPay성공 get방식");
      // 결제 승인요청을 인증하는 토큰
      System.out.println("kakaopay pg_token : "+pg_token);
      
      kakaoPayApprovalVO = kakaopay.kakaoPayInfo(pg_token,session);
       Calendar cal = Calendar.getInstance();
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       cal.setTime(new Date());
       // 티켓아이디가 베이직 1개월이거나 프리미엄 1개월 이라면 만료일을 1개월 증가시켜준다
       if(ticket_id.equals("00101") || ticket_id.equals("00201")) {
          cal.add(Calendar.MONTH, 1);
       }
       else if(ticket_id.equals("00103") || ticket_id.equals("00203")) {
          cal.add(Calendar.MONTH, 3);
       }
       else if(ticket_id.equals("00106") || ticket_id.equals("00206")) {
          cal.add(Calendar.MONTH, 6); 
       }
       else if(ticket_id.equals("00112") || ticket_id.equals("00212")) {
          cal.add(Calendar.MONTH, 12); 
       }
       Date date = format.parse(format.format(cal.getTime()));
       // 결제내역 vo
       if(kakaoPayApprovalVO.getCard_info() != null) {
          sales = new SalesVO(kakaoPayApprovalVO.getPartner_order_id(),kakaoPayApprovalVO.getCid(),kakaoPayApprovalVO.getTid(),kakaoPayApprovalVO.getPartner_user_id(),ticket_id,"SUCCESS",new Date(),date,kakaoPayApprovalVO.getPayment_method_type(),kakaoPayApprovalVO.getCard_info().getPurchase_corp());
          
       }else if(kakaoPayApprovalVO.getCard_info() == null) {
          sales = new SalesVO(kakaoPayApprovalVO.getPartner_order_id(),kakaoPayApprovalVO.getCid(),kakaoPayApprovalVO.getTid(),kakaoPayApprovalVO.getPartner_user_id(),ticket_id,"SUCCESS",new Date(),date,kakaoPayApprovalVO.getPayment_method_type());
      
       }
 
      // db에 결제 내역 저장
      service.insertSalesInfo(sales);
      
      
      // 해당사용자 member테이블에 이용권 추가해야됨
      member = (MemberVO)session.getAttribute("member");
      System.out.println("해당사용자는 :"+member.getEmail());
      member.setTicket_id(ticket_id);
      memberService.updateTicket(member);
      
      // info라는 이름으로 카카오페이 결제정보를 바인딩해준다
      model.addAttribute("info", kakaoPayApprovalVO);
        // 결제 성공페이지로 이동
      return "views/member/kakaoPaySuccess";
        
     
     
   }
   
   
   @ResponseBody
   @PostMapping("/kakaoPayCancel.do")
   public int kakaoPayCancel(Model model,String tid,String total, AdminSalesVO vo) {
      System.out.println("결제 취소");
      System.out.println(tid);
      System.out.println(total);
      
      KakaoPayCancelVO data = new KakaoPayCancelVO();
   
      data = kakaopay.kakaoPayCancle(tid,total);

      return 1;
   } 
}