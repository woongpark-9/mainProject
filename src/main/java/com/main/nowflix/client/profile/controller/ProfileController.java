package com.main.nowflix.client.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.service.ProfileService;
import com.main.nowflix.client.profile.vo.ProfileVO;

@SessionAttributes("member")
@Controller
public class ProfileController {

	@Autowired
	ProfileService service;

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/profile.do")
	public String profile(HttpSession session, Model model, ProfileVO vo) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");

		model.addAttribute("profile", service.getProfileList(vo, member));

		return "/views/member/profile";
	}

	@RequestMapping(value = "/profileAdd.do")
	public String profileAdd(HttpSession session) {
		return "/views/member/profileAdd";
	}

	@RequestMapping(value = "/profileEdit.do")
	public String profileEdit(HttpSession session, ProfileVO vo, Model model) throws Exception {
		vo = service.getProfile(vo);
		model.addAttribute("selectProfile", vo);
		System.out.println("������ �������ý� profileVO" + vo.toString());
		return "/views/member/profileEdit";
	}

	@RequestMapping(value = "/deleteProfile.do")
	public String deleteProfile(HttpSession session, Model model, ProfileVO profileVO) throws Exception {
		model.addAttribute("selectProfile", profileVO);
		System.out.println("deleteProfile.do���� ������ ����");
		service.deleteProfile(profileVO);

		return "forward:profile.do";
	}

	@RequestMapping(value = "/manageProfiles.do")
	public String manageProfiles(HttpSession session, Model model, ProfileVO vo) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("profile", service.getProfileList(vo, member));
		return "/views/member/manageProfiles";
	}

	@RequestMapping(value = "/updateProfile.do")
	public String updateProfile(HttpSession session, Model model, ProfileVO vo) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		service.updateProfile(vo);
		model.addAttribute("profile", service.getProfileList(vo, member));
		return "/views/member/profile";
	}

	@RequestMapping(value = "/selectProfileImg.do")
	public String selectProfileImg(Model model, ProfileVO vo) throws Exception {
		model.addAttribute("profile", vo);
		return "/views/member/selectProfileImg";
	}

	@RequestMapping(value = "updateProfileEdit.do")
	public String updateProfileEdit(HttpSession session, Model model, ProfileVO vo) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		if (vo.getKids() == null) {
			vo.setKids("N");
		}
		service.updateProfileEdit(vo);
		model.addAttribute("profile", service.getProfileList(vo, member));
		return "/views/member/profile";
	}

	// HttpSession session�� �Ű������� �Է��ϸ� ������ ����� memberVO�� �����ü��մ�.
	// HttpSession session�� �Ű������� �Է��ϸ� ������ ����� memberVO�� �����ü��մ�.
	@RequestMapping("setGenre.do")
	public String setgenre(HttpServletRequest request, Model model, MovieVO movieVO, HttpSession session)
			throws Exception {
		System.out.println("setGenre.do ����");
		MemberVO member = (MemberVO) session.getAttribute("member");
		String[] arr = request.getParameterValues("checkbox");
//	      ProfileVO addProfileVO = (ProfileVO)model.getAttribute("profileVO");
//	      System.out.println("setGenre.do�� addProfileVO" + addProfileVO);

		member = memberService.getMember(member);

		System.out.println("setGenre.do���� member genreȮ��" + member.toString());

		service.setProfile(arr, member);

		memberService.setGenre(member);

//	      service.setProfile(arr, member, addProfileVO);

		return "forward:profile.do";
	}

	@RequestMapping(value = "/createProfile.do")
	public String createProfile(HttpSession session, Model model, ProfileVO profileVO) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("profileVO", profileVO);
		System.out.println("11createProfile.do�� ��������" + profileVO);
		if (profileVO.getKids() == null) {
			profileVO.setKids("N");
		}

		profileVO = service.createProfile(profileVO, member);

//	         service.getProfile(vo)

//	         model.addAttribute("profile", service.getProfileList(profileVO, member));

		System.out.println("createProfile.do�� ��������" + profileVO);
		return "forward:favoriteNew.do";
	}

}