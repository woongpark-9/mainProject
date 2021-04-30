package com.main.nowflix.admin.sales.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.sales.vo.AdminSalesVO;

@Repository
public class AdminSalesDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 결제내역 리스트 가져오기
	public List<AdminSalesVO> getSalesList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getSalesList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminSalesDAO.getSalesList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminSalesDAO.getTotalCount", map);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminSalesVO> selectBoardList(AdminSalesVO vo) {
		return sqlSessionTemplate.selectList("AdminSalesDAO.selectBoardList");
	}
}
