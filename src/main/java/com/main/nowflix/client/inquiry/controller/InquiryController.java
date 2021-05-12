package com.main.nowflix.client.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.faq.service.FaqService;
import com.main.nowflix.client.faq.vo.FaqVO;
import com.main.nowflix.client.inquiry.service.InquiryService;
import com.main.nowflix.client.inquiry.vo.InquiryVO;
import com.main.nowflix.client.member.service.MemberService;
import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.profile.vo.ProfileVO;

@SessionAttributes("member")
@Controller
public class InquiryController {

	@Autowired
	InquiryService inquiryService;

	@Autowired
	MemberService memberService;

	@Autowired
	FaqService faqService;

//	
//	@RequestMapping(value="/insertinquiry.do")
//	public String insertinquiry(Model model) {
//		
//	}

	@RequestMapping(value = "/getInquiryList.do")
	public String getInquiryList(InquiryVO vo, Model model, MemberVO member, HttpSession session,ProfileVO profile) throws Exception {
		member = (MemberVO) session.getAttribute("member");
		vo.setEmail(member.getEmail());
		System.out.println("inquiry" + vo.getEmail());
		List<InquiryVO> inquiryList = inquiryService.getInquiryList(vo);
		for (InquiryVO v : inquiryList) {
			System.out.println(v.getInquiry_id());
		}
		
		model.addAttribute("profile", profile);
		model.addAttribute("inquiryList", inquiryList);
		session.setAttribute("inquiryList", inquiryList);
		return "/views/member/inquiryList";
	}

	@RequestMapping(value = "/getInquiryFAQ.do")
	public String getInquiryFAQ(FaqVO vo, MemberVO member, Model model, HttpSession session,ProfileVO profile) throws Exception {

		member = (MemberVO) session.getAttribute("member");
		List<FaqVO> faqList = faqService.getFaqList(vo);
		List<FaqVO> registList = new ArrayList<FaqVO>();
		List<FaqVO> payList = new ArrayList<FaqVO>();
		
		for(int i=0; i<faqList.size(); i++) {
			if(faqList.get(i).getFaq_category().equals("회원가입")) {
				registList.add(faqList.get(i));
			}
			if(faqList.get(i).getFaq_category().equals("결제")) {
				payList.add(faqList.get(i));
			}
		}
		
		model.addAttribute("profile", profile);
		model.addAttribute("member", member);
		model.addAttribute("registList", registList);
		model.addAttribute("payList",payList);
		return "/views/member/inquiry_faq";
	}

	@RequestMapping(value = "/getInsertInquiry.do")
	public String getInsertInquiry(InquiryVO vo, MemberVO member, Model model, HttpSession session,ProfileVO profile) {
		member = (MemberVO) session.getAttribute("member");
		model.addAttribute("profile", profile);
		model.addAttribute("member", member);
		return "views/member/insertInquiry";
	}

	@RequestMapping(value = "insertInquiry.do")
	public String insertInquiry(InquiryVO vo, MemberVO member, Model model, HttpSession session,ProfileVO profile) throws Exception {
		member = (MemberVO) session.getAttribute("member");
		model.addAttribute("profile", profile);
		model.addAttribute("member", member);
		inquiryService.insertInquiry(vo);
		return "redirect:/getInquiryList.do";
	}

	@RequestMapping(value = "inquiryDetail.do")
	public String inquiryDetail(InquiryVO vo, MemberVO member, Model model, HttpSession session,String inquiry_id,ProfileVO profile) throws Exception {
		member = (MemberVO) session.getAttribute("member");
		List<InquiryVO> inquiryList = (List) session.getAttribute("inquiryList");
		List<InquiryVO> inquiryDetailList = new ArrayList<InquiryVO>();

		System.out.println(inquiryList.get(0).getEmail());
		for (int i = 0; i < inquiryList.size(); i++) {
			if (inquiryList.get(i).getInquiry_id() == Integer.parseInt(inquiry_id)) {
				inquiryDetailList.add(inquiryList.get(i));
			}
		}
		model.addAttribute("profile", profile);
		model.addAttribute("inquiryDetailList", inquiryDetailList);
		model.addAttribute("member", member);
		return "/views/member/inquirydetail";

	}

}
