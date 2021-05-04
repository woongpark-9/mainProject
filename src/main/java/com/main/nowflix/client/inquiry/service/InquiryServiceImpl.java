package com.main.nowflix.client.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.inquiry.dao.InquiryDAO;
import com.main.nowflix.client.inquiry.vo.InquiryVO;
@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryDAO dao;
	
	
	@Override
	public void insertInquiry(InquiryVO vo) throws Exception {
		dao.insertInquiry(vo);
		
	}

	@Override
	public List<InquiryVO> getInquiryList(InquiryVO vo) throws Exception {
		return dao.getInquiryList(vo);
	}
	
}
