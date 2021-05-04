package com.main.nowflix.client.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.inquiry.vo.InquiryVO;
@Repository
public class InquiryDAO {
	@Autowired
	private SqlSession sql;
	
	public void insertInquiry(InquiryVO vo) {
		sql.insert("inquiryMapper.insertInquiry",vo);
	}
	
	public List<InquiryVO> getInquiryList(InquiryVO vo){
		return sql.selectList("inquiryMapper.getInquiryList", vo);
	}
}
