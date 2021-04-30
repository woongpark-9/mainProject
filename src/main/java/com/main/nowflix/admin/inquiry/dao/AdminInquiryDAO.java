package com.main.nowflix.admin.inquiry.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.inquiry.vo.AdminInquiryVO;

@Repository
public class AdminInquiryDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// ���� ����Ʈ ��������
	public List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getInquiryList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminInquiryDAO.getInquiryList", map);
	}
	// ���� �� ����
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminInquiryDAO.getTotalCount", map);
	}

	// ���� �߰�
	public int insertInquiry(AdminInquiryVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertInquiry() ��� ó��");
		return sqlSessionTemplate.insert("AdminInquiryDAO.insertInquiry", vo);
	}

	// ���� ����
	public int deleteInquiry(AdminInquiryVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteInquiry() ��� ó��");
		return sqlSessionTemplate.delete("AdminInquiryDAO.deleteInquiry", vo);
	}

	// ���� ����
	public int modifyInquiry(AdminInquiryVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyInquiry() ��� ó��");
		return sqlSessionTemplate.update("AdminInquiryDAO.modifyInquiry", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminInquiryVO> selectBoardList(AdminInquiryVO vo) {
		return sqlSessionTemplate.selectList("AdminInquiryDAO.selectBoardList");
	}
}
