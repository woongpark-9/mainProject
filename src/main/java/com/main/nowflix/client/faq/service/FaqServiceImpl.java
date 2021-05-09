package com.main.nowflix.client.faq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.faq.dao.FaqDAO;
import com.main.nowflix.client.faq.vo.FaqVO;


@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqDAO dao;
	
	@Override
	public List<FaqVO> getFaqList(FaqVO vo) throws Exception {
		return dao.getFaqList(vo);
	}
	
}
