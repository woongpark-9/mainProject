package com.main.nowflix.client.profile.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.service.ProfileService;
import com.main.nowflix.client.profile.vo.ProfileVO;

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
		return "/views/member/profile";
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
	
	@RequestMapping("setGenre.do")
	public String setgenre(HttpServletRequest request, Model model, MovieVO movieVO, ProfileVO profileVO)throws Exception{
		System.out.println("setGenre.do ½ÇÇà");
		String[] arr= request.getParameterValues("checkbox");
		
		service.setProfile(arr);
	
		
		
		return "redirect:profile.do";
	}
}
