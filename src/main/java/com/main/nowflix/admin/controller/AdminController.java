package com.main.nowflix.admin.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Controller
public class AdminController {	
	//템플릿(메인) 페이지
	@RequestMapping("/manage_template.mdo")
	public String getTemplate() {
		System.out.println("Get Template");
		return "manage_template";
	}
	
	// 영화 추가 페이지 
	@RequestMapping("/movie_insert.mdo")
	public String getMovie_insert() {

		return "movie_insert";
	}
	
	@RequestMapping("/manage_actor.mdo")
	public String getActor() {

		return "manage_actor";
	}

	@RequestMapping("/manage_analysis.mdo")
	public String getAnalysis() {

		return "manage_analysis";
	}

	@RequestMapping("/manage_cs.mdo")
	public String getCs() {

		return "manage_cs";
	}

	@RequestMapping("/manage_dashboard.mdo")
	public String getDashboard() {

		return "manage_dashboard";
	}

	@RequestMapping("/manage_director.mdo")
	public String getDirector() {

		return "manage_director";
	}

	@RequestMapping("/manage_genre.mdo")
	public String getGenre() {

		return "manage_genre";
	}

	@RequestMapping("/manage_manageraccount.mdo")
	public String getManagerAccount() {

		return "manage_manageraccount";
	}

	@RequestMapping("/manage_member.mdo")
	public String getMember() {

		return "manage_member";
	}
	
	@RequestMapping("/manage_ticket.mdo")
	public String getTicket() {

		return "manage_ticket";
	}

	@RequestMapping("/manage_policy.mdo")
	public String getPolicy() {

		return "manage_policy";
	}

	@RequestMapping("/manage_sales.mdo")
	public String getSales() {

		return "manage_sales";
	}

	@RequestMapping("/manage_screen.mdo")
	public String getScreen() {

		return "manage_screen";
	}

	@RequestMapping("/member_insert.mdo")
	public String getMemberInsert() {

		return "member_insert";
	}
}
