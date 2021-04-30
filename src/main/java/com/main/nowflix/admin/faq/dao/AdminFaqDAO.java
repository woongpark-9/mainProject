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

	// 공지사항 리스트 가져오기
	public List<AdminFaqVO> getFaqList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getFaqList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminFaqDAO.getFaqList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminFaqDAO.getTotalCount", map);
	}

	// 공지사항 추가
	public int insertFaq(AdminFaqVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertFaq() 기능 처리");
		return sqlSessionTemplate.insert("AdminFaqDAO.insertFaq", vo);
	}

	// 공지사항 삭제
	public int deleteFaq(AdminFaqVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteFaq() 기능 처리");
		return sqlSessionTemplate.delete("AdminFaqDAO.deleteFaq", vo);
	}

	// 공지사항 수정
	public int modifyFaq(AdminFaqVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyFaq() 기능 처리");
		return sqlSessionTemplate.update("AdminFaqDAO.modifyFaq", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminFaqVO> selectBoardList(AdminFaqVO vo) {
		return sqlSessionTemplate.selectList("AdminFaqDAO.selectBoardList");
	}
}
