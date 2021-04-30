package com.main.nowflix.admin.faq.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.faq.vo.AdminFaqVO;

@Repository
public class AdminFaqDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// �������� ����Ʈ ��������
	public List<AdminFaqVO> getFaqList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getFaqList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminFaqDAO.getFaqList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminFaqDAO.getTotalCount", map);
	}

	// �������� �߰�
	public int insertFaq(AdminFaqVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertFaq() ��� ó��");
		return sqlSessionTemplate.insert("AdminFaqDAO.insertFaq", vo);
	}

	// �������� ����
	public int deleteFaq(AdminFaqVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteFaq() ��� ó��");
		return sqlSessionTemplate.delete("AdminFaqDAO.deleteFaq", vo);
	}

	// �������� ����
	public int modifyFaq(AdminFaqVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyFaq() ��� ó��");
		return sqlSessionTemplate.update("AdminFaqDAO.modifyFaq", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminFaqVO> selectBoardList(AdminFaqVO vo) {
		return sqlSessionTemplate.selectList("AdminFaqDAO.selectBoardList");
	}
}
