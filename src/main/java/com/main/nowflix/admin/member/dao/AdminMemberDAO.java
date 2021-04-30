package com.main.nowflix.admin.member.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Repository
public class AdminMemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 수정이필요합니다.
//	public int get_all_member_count(AdminMemberVO memberVO) {
//		System.out.println("DAO 작동 ---> MyBatis로 get_all_member_count() 기능 처리");
//		return sqlSessionTemplate.selectOne("AdminMemberDAO.get_all_member_count", memberVO);
//	}

	public List<AdminMemberVO> getMemberList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getMemberList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminMemberDAO.getMemberList", map);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getMemberModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMemberDAO.getTotalCount", map);
	}

	// PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminMemberVO> selectBoardList(AdminMemberVO memberVO) {
		return sqlSessionTemplate.selectList("AdminMemberDAO.selectBoardList");
	}

	public AdminMemberVO getMemberModifyInfo(AdminMemberVO memberVO) {
		System.out.println("DAO 작동 ---> MyBatis로 getMemberModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMemberDAO.getMemberModifyInfo", memberVO);
	}

	public int insertMember(AdminMemberVO memberVO) {
		System.out.println("DAO작동 ---> MyBatis로 insertMovie() 기능 처리");
		return sqlSessionTemplate.insert("AdminMemberDAO.insertMember", memberVO);
	}

	public int modifyMember(AdminMemberVO memberVO) {
		System.out.println("DAO 작동 ---> MyBatis로 modifyMember() 기능 처리");
		return sqlSessionTemplate.update("AdminMemberDAO.modifyMember", memberVO);
	}

	public List<AdminMemberVO> ageList(AdminMemberVO memberVO) {
		System.out.println("DAO 실행--> MyBatis 로 실행 ageList()");
		return sqlSessionTemplate.selectList("AdminMemberDAO.ageList", memberVO);
	}
}
