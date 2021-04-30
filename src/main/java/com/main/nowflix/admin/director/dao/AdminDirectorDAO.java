package com.main.nowflix.admin.director.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.director.vo.AdminDirectorVO;

@Repository
public class AdminDirectorDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// ���� ����Ʈ ��������
	public List<AdminDirectorVO> getDirectorList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getDirectorList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminDirectorDAO.getDirectorList", map);
	}

	// ���� ����Ʈ �������� withoutPaging
	public List<AdminDirectorVO> getDirectorListWithoutPaging(AdminDirectorVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getDirectorListWithoutPaging() ��� ó��");
		return sqlSessionTemplate.selectList("AdminDirectorDAO.getDirectorListWithoutPaging", vo);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminDirectorDAO.getTotalCount", map);
	}

	// ���� �߰�
	public int insertDirector(AdminDirectorVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertDirector() ��� ó��");
		return sqlSessionTemplate.insert("AdminDirectorDAO.insertDirector", vo);
	}

	// ���� ����
	public int deleteDirector(AdminDirectorVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteDirector() ��� ó��");
		return sqlSessionTemplate.insert("AdminDirectorDAO.deleteDirector", vo);
	}

	// ���� ����
	public int modifyDirector(AdminDirectorVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyDirector() ��� ó��");
		return sqlSessionTemplate.insert("AdminDirectorDAO.modifyDirector", vo);
	}

	// PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminDirectorVO> selectBoardList(AdminDirectorVO vo) {
		return sqlSessionTemplate.selectList("AdminDirectorDAO.selectBoardList");
	}
}
