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
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	// ����ڰ� �����Ϸ��� Ƽ�Ͼ��̵�
	private String ticket_id;
	
	// ���������� ���� vo��ü
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	
	@Autowired
	private SalesService service;
	
	@Autowired
	private MemberService memberService;
	
	private MemberVO member;
	
	
	// /kakaoPay get���
	@GetMapping("/kakaoPay.do")
	public void kakaoPayGet() {
		
	}
	// /kakaoPay post���
	@PostMapping("/kakaoPay.do")
	public String kakaoPay(String total_amount,String item_name,String ticket_id,Model model,HttpSession session) {
		// ����������ȣ,��������ĺ���(universally unique identifier)�� ������ UUID Ŭ���� ���
		String partner_order_id = UUID.randomUUID().toString();
		// ���� �����Ϸ��� ����ڰ� �������� ��������  member�̸����� ���ε��� ��ü�� �����´� 
		member = (MemberVO) session.getAttribute("member");
		System.out.println("������ ��� : "+member.getEmail()); 
		// �����Ϸ��� Ƽ�Ͼ��̵�
		this.ticket_id = ticket_id;
		// �����Ϸ��� ���
		String partner_user_id = member.getEmail();
		
		// �����غ�� �̵�
		return "redirect:" +kakaopay.kakaopayReady(total_amount,item_name,model,partner_order_id,partner_user_id);
 	}
	
	@GetMapping("/kakaoPaySuccess.do")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model,HttpServletRequest request,HttpSession session) throws Exception {
		System.out.println("kakaoPay���� get���");
		// ���� ���ο�û�� �����ϴ� ��ū
		System.out.println("kakaopay pg_token : "+pg_token);
		
		kakaoPayApprovalVO = kakaopay.kakaoPayInfo(pg_token,session);
		 Calendar cal = Calendar.getInstance();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 cal.setTime(new Date());
		 // Ƽ�Ͼ��̵� ������ 1�����̰ų� �����̾� 1���� �̶�� �������� 1���� ���������ش�
		 if(ticket_id.equals("0011") || ticket_id.equals("0021")) {
			 cal.add(Calendar.MONTH, 1);
		 }
		 else if(ticket_id.equals("0013") || ticket_id.equals("0023")) {
			 cal.add(Calendar.MONTH, 3);
		 }
		 else if(ticket_id.equals("0016") || ticket_id.equals("0026")) {
			 cal.add(Calendar.MONTH, 6); 
		 }
		 else if(ticket_id.equals("00112") || ticket_id.equals("00212")) {
			 cal.add(Calendar.MONTH, 12); 
		 }
		 Date date = format.parse(format.format(cal.getTime()));
		 // �������� vo
		SalesVO vo = new SalesVO(kakaoPayApprovalVO.getPartner_order_id(),kakaoPayApprovalVO.getCid(),kakaoPayApprovalVO.getTid(),kakaoPayApprovalVO.getPartner_user_id(),ticket_id,"SUCCESS",new Date(),date,kakaoPayApprovalVO.getPayment_method_type(),kakaoPayApprovalVO.getCard_info().getPurchase_corp());

		// db�� ���� ���� ����
		service.insertSalesInfo(vo);
		
		
		// �ش����� member���̺� �̿�� �߰��ؾߵ�
		member = (MemberVO)session.getAttribute("member");
		System.out.println("�ش����ڴ� :"+member.getEmail());
		member.setTicket_id(ticket_id);
		memberService.updateTicket(member);
		
		// info��� �̸����� īī������ ���������� ���ε����ش�
		model.addAttribute("info", kakaoPayApprovalVO);
        // ���� ������������ �̵�
		return "views/member/kakaoPaySuccess";
        
     
     
	}
	
	@PostMapping("/kakaoPayCancel.do")
	public String kakaoPayCancel(Model model) {
		System.out.println("���� ���");
		KakaoPayCancelVO data = new KakaoPayCancelVO();
		
		data =	kakaopay.kakaoPayCancle();
	
		model.addAttribute("data", data);
		
		return "views/member/kakaoPayCancelSuccess";
		
	}
	
}
