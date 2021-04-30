package com.main.nowflix.admin.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.admin.dashboard.service.AdminDashBoardService;
import com.main.nowflix.admin.member.service.AdminMemberService;
import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;



@Controller
public class AdminDashBoardController {
	@Autowired
	private AdminDashBoardService DashBoardService;
	@Autowired
	private AdminMemberService AdminMemberService;
	@Autowired
	private AdminMovieService AdminMovieService;
	
	
//	@RequestMapping("/manage_dashboard.mdo")
//	public String getMovie(AdminMovieVO Movievo , AdminMemberVO Membervo, Model model) {
//		model.addAttribute("all_movie_count", AdminMovieService.get_all_movie_count(Movievo)); // Model 정보저장
//		System.out.println("컨트롤러" + AdminMovieService.get_all_movie_count(Movievo));
//		
//		model.addAttribute("all_member_count", AdminMemberService.get_all_member_count(Membervo)); // Model 정보저장
//		System.out.println("컨트롤러" + AdminMemberService.get_all_member_count(Membervo));
//		return "manage_dashboard";
//	}
	
}
