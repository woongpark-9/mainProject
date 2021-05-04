package com.main.nowflix.client.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.nowflix.client.inquiry.service.InquiryService;

public class InquiryController {

	@Autowired
	InquiryService inquiryService;
	
	
	@RequestMapping(value="/insertinquiry.do")
	public String insertinquiry(Model model) {
		
	}
	
	
}
