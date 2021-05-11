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
	
	
	//암호화기능사용 BCryptPasswordEncoder
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	//회원가입 get
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String getRegister(Model model,String email) throws Exception {
		System.out.println("get 회원가입");
		model.addAttribute("emailtext",email);
		return "views/member/register";
	}
	//회원가입 post방식
		@RequestMapping(value="/register.do",method=RequestMethod.POST)
		public String postRegister(MemberVO vo)throws Exception {
			System.out.println("post 회원가입");
			int result = service.idCheck(vo);
			try {
				// 입력된 아이디가 존재하면 회원가입 페이지로 돌아가기
				if(result == 1) {
					
					return "/views/member/register";
				}
				//입력된 아이디가 존재하지 않는다면 회원가입 처리
				// 비밀번호를 암호화하여 vo에 넣은다음에  서비스 호출
				else if(result == 0) {
					String inputPass = vo.getPass();
					String pwd = pwdEncoder.encode(inputPass);
					String code = SHA256.getSHA256(vo.getEmail());
					vo.setPass(pwd);
					vo.setCert(code);
					vo.setJoin_date(new Date());
					service.register(vo);
					// 이메일 인증 체크
					sendMail.mailCheck(vo.getEmail());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return "/views/member/sendMail";
		}
	//get 방식 로그인 페이지로 
	@RequestMapping(value = "/login.do" ,method=RequestMethod.GET)
	public String login(Model model) {
		System.out.println("login_get요청");
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", snsLogin.getNaverAuthURL());

		return "/views/member/memberLogin";
	}
	// post 방식 로그인 처리
	
		@RequestMapping(value = "/login.do",method = RequestMethod.POST)
		public String login(MemberVO vo, HttpSession session, RedirectAttributes rttr,Model model,HttpServletResponse response) throws Exception{
			String page;
			
			
			System.out.println("login_post요청");
			session.getAttribute("member");
			// 해당하는 email의 db안의 email과 pass 가져오기
			MemberVO login = service.login(vo);
			boolean pwdMatch = false;
//			 입력한 비밀번호와 db의 비밀번호를 비교
			if(login!= null) {
				pwdMatch = pwdEncoder.matches(vo.getPass(), login.getPass());
			}
			if(login != null && pwdMatch == true) {
				session.setAttribute("member", login);
				System.out.println("로그인성공");
				// 이메일 인증 확인
				String result = login.getCert();
				
				System.out.println(result);
				// 이메일 인증을 하지않았다면
				if(!result.equals("Y")) {
					page = "redirect:/certCheckFail.do";
					return page;
					
				}
				// 이메일 인증을 했다면 이용권이 있는지 확인
				else {
					String ticketCheck = service.ticketCheck(login);
				
						// 접속한 유저가 이용권을 가지고 있지 않다면 결제페이지로 이동
					if(ticketCheck.equals("N")) {
					
							page = "redirect:selectTicket.do";
							return page;
					}
					
					System.out.println("해당 유저의 이용권 : "+ticketCheck);
				}
				// 장르를 선택했는지 확인
				
				String genreCheck = service.genreCheck(login);
	            if(genreCheck.equals("N")) {
	               System.out.println("장르페이지로 이동합니다");
	               page = "redirect:favorite.do";
	               return page;
	            }
	            // 장르를 선택했다면 프로필 페이지로
	            page = "redirect:profile.do";
	            return page;
				
			
			}else {
				session.setAttribute("member", null);
				ScriptUtils.alert(response, "아이디가 존재하지 않거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다");
				
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
	// 아이디 중복확인
	@ResponseBody
	@RequestMapping(value="/idCheck.do",method=RequestMethod.POST)
	public int idCheck(MemberVO vo)throws Exception{
		int result = service.idCheck(vo);
		System.out.println(vo.getEmail());
		
		return result;
	}
	// 장르선택
	@RequestMapping(value="/index.jsp")
	public String don() {
		return "redirect:/";
	}
	// 확인을 위한것 나중에 삭제 티켓구매 1단계
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
	
	// 이메일인증
		@RequestMapping(value="/emailCheck.do")
		public String emailCheck(MemberVO vo) throws Exception {
			MemberVO email = new MemberVO();
			email.setEmail(service.certCheck(vo));
			if (email.getEmail() != null) {
				service.certUpdate(email);
			}
			return "/views/member/emailCheck";
		}
		
		// 이메일 인증 실패
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
		
		//티켓 타입 전달
		@ResponseBody
		@RequestMapping(value="/setTicketType.do",method=RequestMethod.POST)
		public int ticketTypeCheck(String ticketType )throws Exception{
			System.out.println(ticketType);
			
			// 리턴은 상태값 리턴 -1 이면 실패 0이면 성공 
			return 0;
		}
		
//		@RequestMapping(value="/request_ticket_step2.do")
//		public String request_ticket_step2(Model model,String ticketType) {
//			model.addAttribute(")
//			return "redirect:ticket_step2.do";
//		}
//		
		
		
		//결제 전 추가정보입력
		@ResponseBody
		@RequestMapping(value="/addInfo.do")
		public int addInfo(String gender , String birthday,HttpSession session) throws Exception {
			// email 값을 얻기 위해 현재유저 정보 꺼내오기
			MemberVO addinfo = new MemberVO();
			addinfo = (MemberVO)session.getAttribute("member");
			System.out.println(addinfo.getEmail());
			// 성별 설정
			if(gender.equals("남")) {
				gender = "M";
				addinfo.setGender(gender);
			}else if(gender.equals("여")) {
				gender = "W";
				addinfo.setGender(gender);
			}
			// 생년월일 설정
			addinfo.setBirth(birthday);
			service.addinfo(addinfo);
			// 잘 되었다면 0 리턴
			return 0;
		}
	
		
		
		@RequestMapping(value="/ticket_step2.do")
		public String getStep2(String ticketType,Model model) throws Exception {
	    // 작업해야할것 : 티켓 테이블에서 해당 티켓의 정보를 가져와 바인딩해주기
			String ticketText = "";
			String ticket_name = "";
			System.out.println("getStep2 : "+ticketType);
			model.addAttribute("ticketType", ticketType);
			// 만약 결제 1단계에서 고른 타입이 002(프리미엄) 라면 
			if(ticketType.equals("002")){
				ticketText = "프리미엄";
				ticket_name = "premium";
			}
			// 만약 결제 1단계에서 고른 타입이 001(베이직) 라면 
			else if(ticketType.equals("001")) {
				ticketText = "베이직";
				ticket_name = "basic";
			}
			TicketVO ticket = new TicketVO(ticket_name);
			List<TicketVO> ticketList = null;
			List<TicketVO> recommendTicketList = new ArrayList<TicketVO>();
			// 해당 티켓의 추천리스트 가져오기
			recommendTicketList = ticketService.getRecommendTicketList(ticket);
			// 해당 티켓의 리스트 가져오기
			ticketList=	ticketService.getNormalTicketList(ticket);
			for(int i=0; i<ticketList.size(); i++) {
				System.out.println(ticketList.get(i).getTicket_price());
			}
				if(ticketList != null && recommendTicketList != null) {
				System.out.println("잘 가져왔음");
			}
			
			// 바인딩 처리
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
				ticketText = "베이직 1개월";
				ticketType = "베이직";
			}else if(salesList.get(0).getTicket_id().equals("00103")) {
				ticketText = "베이직 3개월";
				ticketType = "베이직";
			}else if(salesList.get(0).getTicket_id().equals("00106")) {
				ticketText = "베이직 6개월";
				ticketType = "베이직";
			}else if(salesList.get(0).getTicket_id().equals("00112")) {
				ticketText = "베이직 12개월";
				ticketType = "베이직";
			}else if(salesList.get(0).getTicket_id().equals("00201")) {
				ticketText = "프리미엄 1개월";
				ticketType = "프리미엄";
			}else if(salesList.get(0).getTicket_id().equals("00203")) {
				ticketText = "프리미엄 3개월";
				ticketType = "프리미엄";
			}else if(salesList.get(0).getTicket_id().equals("00206")) {
				ticketText = "프리미엄 6개월";
				ticketType = "프리미엄";
			}else if(salesList.get(0).getTicket_id().equals("00212")) {
				ticketText = "프리미엄 12개월";
				ticketType = "프리미엄";
			}
			
			
			
			model.addAttribute("salesList",salesList);
			model.addAttribute("ticketText",ticketText);
			model.addAttribute("ticketType",ticketType);
			
			
			return "/views/member/settings";
		}
	
		
}
