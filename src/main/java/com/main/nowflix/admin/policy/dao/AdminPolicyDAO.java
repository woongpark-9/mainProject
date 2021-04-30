package com.main.nowflix.admin.policy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.policy.vo.AdminPolicyVO;

@Repository
public class AdminPolicyDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 이용약관 리스트 가져오기
	public List<AdminPolicyVO> getPolicyList(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getPolicyList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminPolicyDAO.getPolicyList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminPolicyDAO.getTotalCount", map);
	}

	// 이용약관 추가
	public int insertPolicy(AdminPolicyVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertPolicy() 기능 처리");
		return sqlSessionTemplate.insert("AdminPolicyDAO.insertPolicy", vo);
	}

	// 이용약관 삭제
	public int deletePolicy(AdminPolicyVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deletePolicy() 기능 처리");
		return sqlSessionTemplate.delete("AdminPolicyDAO.deletePolicy", vo);
	}

	// 이용약관 수정
	public int modifyPolicy(AdminPolicyVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 modifyPolicy() 기능 처리");
		return sqlSessionTemplate.update("AdminPolicyDAO.modifyPolicy", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminPolicyVO> selectBoardList(AdminPolicyVO vo) {
		return sqlSessionTemplate.selectList("AdminPolicyDAO.selectBoardList");
	}
}
