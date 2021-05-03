package com.main.nowflix.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.admin.inquiry.service.AdminInquiryService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminInquiryService inquiryService;
	
	// 템플릿(메인) 페이지
	@RequestMapping("/manage_template.mdo")
	public String getTemplate(Model model) {
		System.out.println("Get Template");
		model.addAttribute("inquiryCount", inquiryService.getInquiryCount()); // inquiryCount 정보저장
		return "manage_template";
	}

	// 티켓 추가 페이지
	@RequestMapping("/ticket_insert.mdo")
	public String getTicket_insert() {

		return "ticket_insert";
	}

	@RequestMapping("/manage_analysis.mdo")
	public String getAnalysis() {

		return "manage_analysis";
	}

	@RequestMapping("/manage_cs.mdo")
	public String getCs() {

		return "manage_cs";
	}

//	@RequestMapping("/manage_sales.mdo")
//	public String getSales() {
//
//		return "manage_sales";
//	}

	@RequestMapping("/manage_screen.mdo")
	public String getScreen() {

		return "manage_screen";
	}

	@RequestMapping("/member_insert.mdo")
	public String getMemberInsert() {

		return "member_insert";
	}
}
