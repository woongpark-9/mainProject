package com.main.nowflix.client.inquiry.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.main.nowflix.client.inquiry.vo.InquiryVO;

public class InquiryDAO {
	@Autowired
	private SqlSession sql;
	public void insertInquiry(InquiryVO vo) {
		sql.insert("inquiryMapper.insertInquiry",vo);
	}
}
