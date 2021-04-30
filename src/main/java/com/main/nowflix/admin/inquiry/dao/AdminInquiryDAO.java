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

	// 문의 리스트 가져오기
	public List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getInquiryList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminInquiryDAO.getInquiryList", map);
	}
	// 문의 총 개수
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminInquiryDAO.getTotalCount", map);
	}

	// 문의 추가
	public int insertInquiry(AdminInquiryVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertInquiry() 기능 처리");
		return sqlSessionTemplate.insert("AdminInquiryDAO.insertInquiry", vo);
	}

	// 문의 삭제
	public int deleteInquiry(AdminInquiryVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteInquiry() 기능 처리");
		return sqlSessionTemplate.delete("AdminInquiryDAO.deleteInquiry", vo);
	}

	// 문의 수정
	public int modifyInquiry(AdminInquiryVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyInquiry() 기능 처리");
		return sqlSessionTemplate.update("AdminInquiryDAO.modifyInquiry", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminInquiryVO> selectBoardList(AdminInquiryVO vo) {
		return sqlSessionTemplate.selectList("AdminInquiryDAO.selectBoardList");
	}
}
