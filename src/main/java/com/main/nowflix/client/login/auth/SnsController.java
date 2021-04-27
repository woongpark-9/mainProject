package com.main.nowflix.client.login.auth;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;

@Controller
public class SnsController {

	@Autowired
	private SnsValue naverSns;

	@Inject
	MemberService service;
	


	@RequestMapping(value = "callbackNaver.do")
	public String snsNaverLoginCallback(Model model, @RequestParam String code) throws Exception {
		String page = "";
		// 1. code를 이용해서 access_token 받기
		// 2. access_token을 이용해서 사용자 profile 정보 가져오기

		SNSLogin snsLogin = new SNSLogin(naverSns);
		// String profile = snsLogin.getUserProfile(code);
		MemberVO snsMember = snsLogin.getMemberProfile(code);

		System.out.println("Profile>>" + snsMember);
//		model.addAttribute("result", snsMember);
		// 3. DB 해당 유저가 존재하는 체크 (googleid, naverid 컬럼 추가)

		// 4. 존재시 강제로그인, 미존재시 가입페이지로 !!
		
		int result = service.oauthEmailCheck(snsMember);
		if(result == 0) {
			// 신규회원이라면 장르선택 페이지로
			System.out.println("네이버 신규회원입니다");
			service.oauthRegister(snsMember);
			page = "redirect:/don.do";
		}else if(result == 1) {
			//프로필 선택 페이지로
			System.out.println("네이버 기존회원입니다 로그인 처리");
			page = "redirect:index.jsp";
		}
		return page;
	
	}

	
//	@RequestMapping("/naverLogin.do")
//	public String login(Model model) throws Exception {
//
//	
//	
//
//		return "login/login";
//	}

}
