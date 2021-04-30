package com.main.nowflix.admin.manager.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.manager.vo.AdminManagerVO;

@Repository
public class AdminManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// ������ ����Ʈ ��������
	public List<AdminManagerVO> getManagerList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getManagerList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminManagerDAO.getManagerList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminManagerDAO.getTotalCount", map);
	}
	
	// ������ �߰�
	public int insertManager(AdminManagerVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertManager() ��� ó��");
		return sqlSessionTemplate.insert("AdminManagerDAO.insertManager", vo);
	}

	// ������ ����
	public int deleteManager(AdminManagerVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteManager() ��� ó��");
		return sqlSessionTemplate.delete("AdminManagerDAO.deleteManager", vo);
	}
	
	// ���� ����
	public int modifyManager(AdminManagerVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyManager() ��� ó��");
		return sqlSessionTemplate.update("AdminManagerDAO.modifyManager", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminManagerVO> selectBoardList(AdminManagerVO vo) {
		return sqlSessionTemplate.selectList("AdminManagerDAO.selectBoardList");
	}
}
