package com.main.nowflix.client.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.service.ProfileService;
import com.main.nowflix.client.profile.vo.ProfileVO;



@SessionAttributes("member")
@Controller
public class ProfileController {
	
	@Autowired
	ProfileService service;
	
	@RequestMapping(value="/profile.do")
	public String profile(Model model, ProfileVO vo) throws Exception {
		model.addAttribute("profile", service.getProfileList(vo));
		return "/views/member/profile";
	}
	
	@RequestMapping(value="/profileAdd.do")
	public String profileAdd() {
		return "/views/member/profileAdd";
	}
	
	@RequestMapping(value="/profileEdit.do")
	public String profileEdit(ProfileVO vo, Model model) throws Exception {
		model.addAttribute("selectProfile", vo);
		return "/views/member/profileEdit";
	}
	
	@RequestMapping(value="/manageProfiles.do")
	public String manageProfiles(Model model, ProfileVO vo) throws Exception {
		model.addAttribute("profile", service.getProfileList(vo));
		return "/views/member/manageProfiles";
	}
	
	@RequestMapping(value="/createProfile.do")
	public String createProfile(Model model, ProfileVO vo) throws Exception {
		service.createProfile(vo);
		model.addAttribute("profile", service.getProfileList(vo));
		return "redirect:profile.do";
	}
	
	@RequestMapping(value="/updateProfile.do")
	public String updateProfile(Model model, ProfileVO vo) throws Exception {
		service.updateProfile(vo);
		model.addAttribute("profile", service.getProfileList(vo));
		return "/views/member/profile";
	}	
	
	@RequestMapping(value="/selectProfileImg.do")
	public String selectProfileImg(Model model, ProfileVO vo) throws Exception {
		model.addAttribute("profile", vo);
		return "/views/member/selectProfileImg";
	}	
	
	//HttpSession session을 매개변수로 입력하면 접속한 사람의 memberVO를 가져올수잇다.
	   @RequestMapping("setGenre.do")
	   public String setgenre(HttpServletRequest request, Model model, MovieVO movieVO, ProfileVO profileVO,HttpSession session)throws Exception{
	      System.out.println("setGenre.do 실행");
	      
	      MemberVO member =   (MemberVO)session.getAttribute("member");
	      String[] arr= request.getParameterValues("checkbox");
	      System.out.println(arr[0]);
	      System.out.println(member.getNickname());
	      
	      
	      
	      service.setProfile(arr, member);
	      
	      
	      return "redirect:profile.do";
	   }
	
	
	
	
	
	
	
}
