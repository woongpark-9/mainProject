package com.main.nowflix.client.sales.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.sales.vo.SalesVO;

// 이용권 만료일 설정하는것 해야됨
@Repository
public class SalesDAO {
	@Autowired
	private SqlSession sql;
	
	
	// 결제정보 db에 저장하는 메서드
	public void insertSalesInfo(SalesVO vo) {
		System.out.println("dao insertSalesInfo 실행");
		sql.insert("salesMapper.insertSalesInfo", vo);
		
	}
}
