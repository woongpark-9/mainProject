package com.main.nowflix.client.member.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.nowflix.client.login.auth.SNSLogin;
import com.main.nowflix.client.login.auth.SnsValue;
import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.sales.service.SalesService;
import com.main.nowflix.client.sales.vo.SalesVO;
import com.main.nowflix.client.ticket.service.TicketService;
import com.main.nowflix.client.ticket.vo.TicketVO;
import com.main.nowflix.util.SHA256;
import com.main.nowflix.util.ScriptUtils;
import com.main.nowflix.util.sendMail;

@Controller
public class MemberController  {
	@Autowired
	MemberService service;

	@Autowired
	TicketService ticketService;
	
	@Autowired
	private SnsValue naverSns;

	@Autowired
	SalesService salesService;
	
	
	//��ȣȭ��ɻ�� BCryptPasswordEncoder
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	//ȸ������ get
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String getRegister(Model model,String email) throws Exception {
		System.out.println("get ȸ������");
		model.addAttribute("emailtext",email);
		return "views/member/register";
	}
	//ȸ������ post���
		@RequestMapping(value="/register.do",method=RequestMethod.POST)
		public String postRegister(MemberVO vo)throws Exception {
			System.out.println("post ȸ������");
			int result = service.idCheck(vo);
			try {
				// �Էµ� ���̵� �����ϸ� ȸ������ �������� ���ư���
				if(result == 1) {
					
					return "/views/member/register";
				}
				//�Էµ� ���̵� �������� �ʴ´ٸ� ȸ������ ó��
				// ��й�ȣ�� ��ȣȭ�Ͽ� vo�� ����������  ���� ȣ��
				else if(result == 0) {
					String inputPass = vo.getPass();
					String pwd = pwdEncoder.encode(inputPass);
					String code = SHA256.getSHA256(vo.getEmail());
					vo.setPass(pwd);
					vo.setCert(code);
					vo.setJoin_date(new Date());
					service.register(vo);
					// �̸��� ���� üũ
					sendMail.mailCheck(vo.getEmail());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return "/views/member/sendMail";
		}
	//get ��� �α��� �������� 
	@RequestMapping(value = "/login.do" ,method=RequestMethod.GET)
	public String login(Model model) {
		System.out.println("login_get��û");
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", snsLogin.getNaverAuthURL());

		return "/views/member/memberLogin";
	}
	// post ��� �α��� ó��
	
		@RequestMapping(value = "/login.do",method = RequestMethod.POST)
		public String login(MemberVO vo, HttpSession session, RedirectAttributes rttr,Model model,HttpServletResponse response) throws Exception{
			String page;
			
			
			System.out.println("login_post��û");
			session.getAttribute("member");
			// �ش��ϴ� email�� db���� email�� pass ��������
			MemberVO login = service.login(vo);
			boolean pwdMatch = false;
//			 �Է��� ��й�ȣ�� db�� ��й�ȣ�� ��
			if(login!= null) {
				pwdMatch = pwdEncoder.matches(vo.getPass(), login.getPass());
			}
			if(login != null && pwdMatch == true) {
				session.setAttribute("member", login);
				System.out.println("�α��μ���");
				// �̸��� ���� Ȯ��
				String result = login.getCert();
				
				System.out.println(result);
				// �̸��� ������ �����ʾҴٸ�
				if(!result.equals("Y")) {
					page = "redirect:/certCheckFail.do";
					return page;
					
				}
				// �̸��� ������ �ߴٸ� �̿���� �ִ��� Ȯ��
				else {
					String ticketCheck = service.ticketCheck(login);
				
						// ������ ������ �̿���� ������ ���� �ʴٸ� ������������ �̵�
					if(ticketCheck.equals("N")) {
					
							page = "redirect:selectTicket.do";
							return page;
					}
					
					System.out.println("�ش� ������ �̿�� : "+ticketCheck);
				}
				// �帣�� �����ߴ��� Ȯ��
				
				String genreCheck = service.genreCheck(login);
	            if(genreCheck.equals("N")) {
	               System.out.println("�帣�������� �̵��մϴ�");
	               page = "redirect:favorite.do";
	               return page;
	            }
	            // �帣�� �����ߴٸ� ������ ��������
	            page = "redirect:profile.do";
	            return page;
				
			
			}else {
				session.setAttribute("member", null);
				ScriptUtils.alert(response, "���̵� �������� �ʰų�, ���̵� �Ǵ� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�");
				
				page = "/views/member/memberLogin";
			}
			
			return page;
		}
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberUpdate.do",method=RequestMethod.POST)
	public String registerUpdateView(MemberVO vo,HttpSession session) throws Exception{
		service.memberUpdate(vo);
		session.invalidate();
		return "redirect:/";
	}
	// ���̵� �ߺ�Ȯ��
	@ResponseBody
	@RequestMapping(value="/idCheck.do",method=RequestMethod.POST)
	public int idCheck(MemberVO vo)throws Exception{
		int result = service.idCheck(vo);
		System.out.println(vo.getEmail());
		
		return result;
	}
	// �帣����
	@RequestMapping(value="/index.jsp")
	public String don() {
		return "redirect:/";
	}
	// Ȯ���� ���Ѱ� ���߿� ���� Ƽ�ϱ��� 1�ܰ�
	@RequestMapping(value="/selectTicket.do")
	public String selectTicket(Model model) throws Exception {
		List<TicketVO> basicticketList = new ArrayList<TicketVO>();
		List<TicketVO> premiumticketList = new ArrayList<TicketVO>();
		basicticketList = ticketService.getTicketList(new TicketVO("basic"));
		premiumticketList = ticketService.getTicketList(new TicketVO("premium"));
		model.addAttribute("basicticketList",basicticketList);
		model.addAttribute("premiumticketList",premiumticketList);
		return "/views/member/selectTicket";
	}
	
	// �̸�������
		@RequestMapping(value="/emailCheck.do")
		public String emailCheck(MemberVO vo) throws Exception {
			MemberVO email = new MemberVO();
			email.setEmail(service.certCheck(vo));
			if (email.getEmail() != null) {
				service.certUpdate(email);
			}
			return "/views/member/emailCheck";
		}
		
		// �̸��� ���� ����
		@RequestMapping(value="/certCheckFail.do")
		public String certCheckFail(HttpSession session, Model model) {
			MemberVO vo = (MemberVO) session.getAttribute("member");
			model.addAttribute("member", vo);
			return "/views/member/certCheckFail";
		}
		
		@RequestMapping(value="/reSend.do")
		public String reSend(String email) {
			sendMail.mailCheck(email);
			return "/views/member/reSendMail";
		}
		
		//Ƽ�� Ÿ�� ����
		@ResponseBody
		@RequestMapping(value="/setTicketType.do",method=RequestMethod.POST)
		public int ticketTypeCheck(String ticketType )throws Exception{
			System.out.println(ticketType);
			
			// ������ ���°� ���� -1 �̸� ���� 0�̸� ���� 
			return 0;
		}
		
//		@RequestMapping(value="/request_ticket_step2.do")
//		public String request_ticket_step2(Model model,String ticketType) {
//			model.addAttribute(")
//			return "redirect:ticket_step2.do";
//		}
//		
		
		
		//���� �� �߰������Է�
		@ResponseBody
		@RequestMapping(value="/addInfo.do")
		public int addInfo(String gender , String birthday,HttpSession session) throws Exception {
			// email ���� ��� ���� �������� ���� ��������
			MemberVO addinfo = new MemberVO();
			addinfo = (MemberVO)session.getAttribute("member");
			System.out.println(addinfo.getEmail());
			// ���� ����
			if(gender.equals("��")) {
				gender = "M";
				addinfo.setGender(gender);
			}else if(gender.equals("��")) {
				gender = "W";
				addinfo.setGender(gender);
			}
			// ������� ����
			addinfo.setBirth(birthday);
			service.addinfo(addinfo);
			// �� �Ǿ��ٸ� 0 ����
			return 0;
		}
	
		
		
		@RequestMapping(value="/ticket_step2.do")
		public String getStep2(String ticketType,Model model) throws Exception {
	    // �۾��ؾ��Ұ� : Ƽ�� ���̺��� �ش� Ƽ���� ������ ������ ���ε����ֱ�
			String ticketText = "";
			String ticket_name = "";
			System.out.println("getStep2 : "+ticketType);
			model.addAttribute("ticketType", ticketType);
			// ���� ���� 1�ܰ迡�� �� Ÿ���� 002(�����̾�) ��� 
			if(ticketType.equals("002")){
				ticketText = "�����̾�";
				ticket_name = "premium";
			}
			// ���� ���� 1�ܰ迡�� �� Ÿ���� 001(������) ��� 
			else if(ticketType.equals("001")) {
				ticketText = "������";
				ticket_name = "basic";
			}
			TicketVO ticket = new TicketVO(ticket_name);
			List<TicketVO> ticketList = null;
			List<TicketVO> recommendTicketList = new ArrayList<TicketVO>();
			// �ش� Ƽ���� ��õ����Ʈ ��������
			recommendTicketList = ticketService.getRecommendTicketList(ticket);
			// �ش� Ƽ���� ����Ʈ ��������
			ticketList=	ticketService.getNormalTicketList(ticket);
			for(int i=0; i<ticketList.size(); i++) {
				System.out.println(ticketList.get(i).getTicket_price());
			}
				if(ticketList != null && recommendTicketList != null) {
				System.out.println("�� ��������");
			}
			
			// ���ε� ó��
			model.addAttribute("ticketText", ticketText);
			model.addAttribute("ticketList", ticketList);
			model.addAttribute("recommendTicketList", recommendTicketList);
			return "/views/member/select_ticket_step2";
		}
		
		
		@RequestMapping(value="/getSettings.do")
		public String getSettings(SalesVO vo , HttpSession session,MemberVO member,Model model) throws Exception {
			member = (MemberVO)session.getAttribute("member");
			vo.setEmail(member.getEmail());
			String ticketText = "";
			String ticketType = "";
			List<SalesVO> salesList = salesService.getSalesInfo(vo);
			System.out.println(salesList.get(0).toString());
			if(salesList.get(0).getTicket_id().equals("00101")) {
				ticketText = "������ 1����";
				ticketType = "������";
			}else if(salesList.get(0).getTicket_id().equals("00103")) {
				ticketText = "������ 3����";
				ticketType = "������";
			}else if(salesList.get(0).getTicket_id().equals("00106")) {
				ticketText = "������ 6����";
				ticketType = "������";
			}else if(salesList.get(0).getTicket_id().equals("00112")) {
				ticketText = "������ 12����";
				ticketType = "������";
			}else if(salesList.get(0).getTicket_id().equals("00201")) {
				ticketText = "�����̾� 1����";
				ticketType = "�����̾�";
			}else if(salesList.get(0).getTicket_id().equals("00203")) {
				ticketText = "�����̾� 3����";
				ticketType = "�����̾�";
			}else if(salesList.get(0).getTicket_id().equals("00206")) {
				ticketText = "�����̾� 6����";
				ticketType = "�����̾�";
			}else if(salesList.get(0).getTicket_id().equals("00212")) {
				ticketText = "�����̾� 12����";
				ticketType = "�����̾�";
			}
			
			
			
			model.addAttribute("salesList",salesList);
			model.addAttribute("ticketText",ticketText);
			model.addAttribute("ticketType",ticketType);
			
			
			return "/views/member/settings";
		}
	
		
}
