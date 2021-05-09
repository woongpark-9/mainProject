package com.main.nowflix.admin.sales.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.movie.vo.AdminMovieVO;
import com.main.nowflix.admin.sales.vo.AdminSalesVO;

@Repository
public class AdminSalesDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// �������� ����Ʈ ��������
	public List<AdminSalesVO> getSalesList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getSalesList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminSalesDAO.getSalesList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminSalesDAO.getTotalCount", map);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminSalesVO> selectBoardList(AdminSalesVO vo) {
		return sqlSessionTemplate.selectList("AdminSalesDAO.selectBoardList");
	}
	
	public List<AdminSalesVO> SalesList(AdminSalesVO salseVO){
		System.out.println("DAO �۵� ---> MyBatis�� getSalesList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminSalesDAO.SalesList",salseVO);
	}

	public List<AdminSalesVO> selectPaymentDataList(AdminSalesVO salseVO){
		System.out.println("DAO �۵� ---> MyBatis�� selectPaymentDataList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminSalesDAO.selectPaymentDataList",salseVO);
	}
	
	public int updateSalesStatus(AdminSalesVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� updateSalesStatus() ��� ó��");
		return sqlSessionTemplate.update("AdminSalesDAO.updateSalesStatus", vo);
	}
}
