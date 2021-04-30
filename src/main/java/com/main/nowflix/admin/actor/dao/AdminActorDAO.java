package com.main.nowflix.admin.actor.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.actor.vo.AdminActorVO;

@Repository
public class AdminActorDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<AdminActorVO> getActorList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getActorList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminActorDAO.getActorList", map);
	}

	public List<AdminActorVO> getActorListWithoutPaging(AdminActorVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getActorListWithoutPaging() ��� ó��");
		return sqlSessionTemplate.selectList("AdminActorDAO.getActorListWithoutPaging", vo);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getActorModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getTotalCount", map);
	}

	public int deleteActor(AdminActorVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteActor() ��� ó��");
		return sqlSessionTemplate.delete("AdminActorDAO.deleteActor", vo);
	}

	public int insertActor(AdminActorVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertActor() ��� ó��");
		return sqlSessionTemplate.insert("AdminActorDAO.insertActor", vo);
	}

	public AdminActorVO getActorModifyInfo(AdminActorVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getActorModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getActorModifyInfo", vo);
	}

	public int modifyActor(AdminActorVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� modifyActor() ��� ó��");
		return sqlSessionTemplate.update("AdminActorDAO.modifyActor", vo);
	}

	// ��ȭ �� ����
	public AdminActorVO getActorDetail(AdminActorVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getActorDetail() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getActorDetail", vo);
	}

	// PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminActorVO> selectBoardList(AdminActorVO vo) {
		return sqlSessionTemplate.selectList("AdminActorDAO.selectBoardList");
	}
}