package com.main.nowflix.admin.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.member.service.AdminMemberService;
import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;
import com.main.nowflix.admin.ticket.service.AdminTicketService;

@Controller
public class AdminAnalysisController {
	@Autowired
	private AdminMemberService memberService;
	@Autowired
	private AdminTicketService ticketService;
	@Autowired
	private AdminMovieService movieService;
	
	//Member �넻怨� 而⑦듃濡�
	@RequestMapping("/manage_analysis_member.mdo")
	public String man_count(AdminMemberVO membervo, AdminAnalysis_Age_VO analysis_age_VO, Model model) {
		model.addAttribute("age_count", memberService.ageList(membervo,analysis_age_VO));
		return "manage_analysis_member";
	}

	//Movie �넻怨� 而⑦듃濡�
	@RequestMapping("manage_analysis_movie.mdo")
	public String movie_count(AdminMovieVO movievo, AdminAnalysis_Age_VO analysis_age_VO, Model model) {
		model.addAttribute("movie_count", movieService.movieList(movievo, analysis_age_VO));
		return "manage_analysis_movie";
	}
}
