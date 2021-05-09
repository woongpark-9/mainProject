package com.main.nowflix.client.faq.service;

import java.util.List;

import com.main.nowflix.client.faq.vo.FaqVO;

public interface FaqService {
	public List<FaqVO> getFaqList(FaqVO vo) throws Exception;
}
