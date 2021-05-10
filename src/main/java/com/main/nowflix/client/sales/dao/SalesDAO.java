package com.main.nowflix.client.sales.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.sales.vo.SalesVO;

// �̿�� ������ �����ϴ°� �ؾߵ�
@Repository
public class SalesDAO {
	@Autowired
	private SqlSession sql;
	
	
	// �������� db�� �����ϴ� �޼���
	public void insertSalesInfo(SalesVO vo) {
		System.out.println("dao insertSalesInfo ����");
		sql.insert("salesMapper.insertSalesInfo", vo);
		
	}
	
	public List<SalesVO> getSalesInfo(SalesVO vo){
		System.out.println("dao getSalesInfo ����");
		return sql.selectList("salesMapper.getSalesInfo", vo);
	}
}
