package com.main.nowflix.client.inquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.client.inquiry.service.InquiryService;
import com.main.nowflix.client.inquiry.vo.InquiryVO;
import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
@Controller
public class InquiryController {

	@Autowired
	InquiryService inquiryService;
	
	@Autowired
	MemberService memberService;
	
//	
//	@RequestMapping(value="/insertinquiry.do")
//	public String insertinquiry(Model model) {
//		
//	}
	
	@RequestMapping(value="/getInquiryList.do")
	public String getInquiryList(InquiryVO vo,Model model,MemberVO member) throws Exception {
		System.out.println("inquiry"+vo.getEmail());
		List<InquiryVO> inquiryList = inquiryService.getInquiryList(vo);
		member = memberService.getMember(member);
		for(InquiryVO i : inquiryList) {
			System.out.print(i.getEmail()+" ");
		}
		model.addAttribute("member",member);
		model.addAttribute("inquiryList",inquiryList);
		return "/views/member/inquiry-member";
	}
	
	
}
