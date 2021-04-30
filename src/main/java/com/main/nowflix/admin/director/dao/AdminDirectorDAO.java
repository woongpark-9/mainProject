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

	// 감독 리스트 가져오기
	public List<AdminDirectorVO> getDirectorList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getDirectorList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminDirectorDAO.getDirectorList", map);
	}

	// 감독 리스트 가져오기 withoutPaging
	public List<AdminDirectorVO> getDirectorListWithoutPaging(AdminDirectorVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getDirectorListWithoutPaging() 기능 처리");
		return sqlSessionTemplate.selectList("AdminDirectorDAO.getDirectorListWithoutPaging", vo);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminDirectorDAO.getTotalCount", map);
	}

	// 감독 추가
	public int insertDirector(AdminDirectorVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertDirector() 기능 처리");
		return sqlSessionTemplate.insert("AdminDirectorDAO.insertDirector", vo);
	}

	// 감독 삭제
	public int deleteDirector(AdminDirectorVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteDirector() 기능 처리");
		return sqlSessionTemplate.insert("AdminDirectorDAO.deleteDirector", vo);
	}

	// 감독 수정
	public int modifyDirector(AdminDirectorVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyDirector() 기능 처리");
		return sqlSessionTemplate.insert("AdminDirectorDAO.modifyDirector", vo);
	}

	// PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminDirectorVO> selectBoardList(AdminDirectorVO vo) {
		return sqlSessionTemplate.selectList("AdminDirectorDAO.selectBoardList");
	}
}
