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
		// 1. code�� �̿��ؼ� access_token �ޱ�
		// 2. access_token�� �̿��ؼ� ����� profile ���� ��������

		SNSLogin snsLogin = new SNSLogin(naverSns);
		// String profile = snsLogin.getUserProfile(code);
		MemberVO snsMember = snsLogin.getMemberProfile(code);

		System.out.println("Profile>>" + snsMember);
//		model.addAttribute("result", snsMember);
		// 3. DB �ش� ������ �����ϴ� üũ (googleid, naverid �÷� �߰�)

		// 4. ����� �����α���, ������� ������������ !!
		
		int result = service.oauthEmailCheck(snsMember);
		if(result == 0) {
			// �ű�ȸ���̶�� �帣���� ��������
			System.out.println("���̹� �ű�ȸ���Դϴ�");
			service.oauthRegister(snsMember);
			page = "redirect:/don.do";
		}else if(result == 1) {
			//������ ���� ��������
			System.out.println("���̹� ����ȸ���Դϴ� �α��� ó��");
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
