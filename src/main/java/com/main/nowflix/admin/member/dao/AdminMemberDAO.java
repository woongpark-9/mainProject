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

	// �������ʿ��մϴ�.
//	public int get_all_member_count(AdminMemberVO memberVO) {
//		System.out.println("DAO �۵� ---> MyBatis�� get_all_member_count() ��� ó��");
//		return sqlSessionTemplate.selectOne("AdminMemberDAO.get_all_member_count", memberVO);
//	}

	public List<AdminMemberVO> getMemberList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getMemberList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminMemberDAO.getMemberList", map);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getMemberModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMemberDAO.getTotalCount", map);
	}

	// PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminMemberVO> selectBoardList(AdminMemberVO memberVO) {
		return sqlSessionTemplate.selectList("AdminMemberDAO.selectBoardList");
	}

	public AdminMemberVO getMemberModifyInfo(AdminMemberVO memberVO) {
		System.out.println("DAO �۵� ---> MyBatis�� getMemberModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminMemberDAO.getMemberModifyInfo", memberVO);
	}

	public int insertMember(AdminMemberVO memberVO) {
		System.out.println("DAO�۵� ---> MyBatis�� insertMovie() ��� ó��");
		return sqlSessionTemplate.insert("AdminMemberDAO.insertMember", memberVO);
	}

	public int modifyMember(AdminMemberVO memberVO) {
		System.out.println("DAO �۵� ---> MyBatis�� modifyMember() ��� ó��");
		return sqlSessionTemplate.update("AdminMemberDAO.modifyMember", memberVO);
	}

	public List<AdminMemberVO> ageList(AdminMemberVO memberVO) {
		System.out.println("DAO ����--> MyBatis �� ���� ageList()");
		return sqlSessionTemplate.selectList("AdminMemberDAO.ageList", memberVO);
	}
}
