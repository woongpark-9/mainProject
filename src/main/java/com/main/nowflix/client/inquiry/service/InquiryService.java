package com.main.nowflix.client.inquiry.service;

import java.util.List;

import com.main.nowflix.client.inquiry.vo.InquiryVO;

public interface InquiryService {
	public void insertInquiry(InquiryVO vo)throws Exception;		
	public List<InquiryVO> getInquiryList(InquiryVO vo)throws Exception;	
}
