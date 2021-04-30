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
		System.out.println("DAO 작동 ---> MyBatis로 getActorList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminActorDAO.getActorList", map);
	}

	public List<AdminActorVO> getActorListWithoutPaging(AdminActorVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getActorListWithoutPaging() 기능 처리");
		return sqlSessionTemplate.selectList("AdminActorDAO.getActorListWithoutPaging", vo);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getActorModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getTotalCount", map);
	}

	public int deleteActor(AdminActorVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteActor() 기능 처리");
		return sqlSessionTemplate.delete("AdminActorDAO.deleteActor", vo);
	}

	public int insertActor(AdminActorVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertActor() 기능 처리");
		return sqlSessionTemplate.insert("AdminActorDAO.insertActor", vo);
	}

	public AdminActorVO getActorModifyInfo(AdminActorVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getActorModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getActorModifyInfo", vo);
	}

	public int modifyActor(AdminActorVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 modifyActor() 기능 처리");
		return sqlSessionTemplate.update("AdminActorDAO.modifyActor", vo);
	}

	// 영화 상세 정보
	public AdminActorVO getActorDetail(AdminActorVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getActorDetail() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminActorDAO.getActorDetail", vo);
	}

	// PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminActorVO> selectBoardList(AdminActorVO vo) {
		return sqlSessionTemplate.selectList("AdminActorDAO.selectBoardList");
	}
}