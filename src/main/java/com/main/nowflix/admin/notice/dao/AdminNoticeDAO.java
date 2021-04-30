package com.main.nowflix.admin.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.notice.vo.AdminNoticeVO;

@Repository
public class AdminNoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 공지사항 리스트 가져오기
	public List<AdminNoticeVO> getNoticeList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getNoticeList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminNoticeDAO.getNoticeList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminNoticeDAO.getTotalCount", map);
	}

	// 공지사항 추가
	public int insertNotice(AdminNoticeVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertNotice() 기능 처리");
		return sqlSessionTemplate.insert("AdminNoticeDAO.insertNotice", vo);
	}

	// 공지사항 삭제
	public int deleteNotice(AdminNoticeVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteNotice() 기능 처리");
		return sqlSessionTemplate.delete("AdminNoticeDAO.deleteNotice", vo);
	}

	// 공지사항 수정
	public int modifyNotice(AdminNoticeVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyNotice() 기능 처리");
		return sqlSessionTemplate.update("AdminNoticeDAO.modifyNotice", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminNoticeVO> selectBoardList(AdminNoticeVO vo) {
		return sqlSessionTemplate.selectList("AdminNoticeDAO.selectBoardList");
	}
}
