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
	
	// 관리자 리스트 가져오기
	public List<AdminManagerVO> getManagerList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getManagerList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminManagerDAO.getManagerList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminManagerDAO.getTotalCount", map);
	}
	
	// 관리자 추가
	public int insertManager(AdminManagerVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertManager() 기능 처리");
		return sqlSessionTemplate.insert("AdminManagerDAO.insertManager", vo);
	}

	// 관리자 삭제
	public int deleteManager(AdminManagerVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteManager() 기능 처리");
		return sqlSessionTemplate.delete("AdminManagerDAO.deleteManager", vo);
	}
	
	// 감독 수정
	public int modifyManager(AdminManagerVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyManager() 기능 처리");
		return sqlSessionTemplate.update("AdminManagerDAO.modifyManager", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminManagerVO> selectBoardList(AdminManagerVO vo) {
		return sqlSessionTemplate.selectList("AdminManagerDAO.selectBoardList");
	}
}
