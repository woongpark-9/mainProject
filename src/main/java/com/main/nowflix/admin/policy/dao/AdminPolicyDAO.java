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

	// �̿��� ����Ʈ ��������
	public List<AdminPolicyVO> getPolicyList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getPolicyList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminPolicyDAO.getPolicyList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminPolicyDAO.getTotalCount", map);
	}

	// �̿��� �߰�
	public int insertPolicy(AdminPolicyVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertPolicy() ��� ó��");
		return sqlSessionTemplate.insert("AdminPolicyDAO.insertPolicy", vo);
	}

	// �̿��� ����
	public int deletePolicy(AdminPolicyVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deletePolicy() ��� ó��");
		return sqlSessionTemplate.delete("AdminPolicyDAO.deletePolicy", vo);
	}

	// �̿��� ����
	public int modifyPolicy(AdminPolicyVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyPolicy() ��� ó��");
		return sqlSessionTemplate.update("AdminPolicyDAO.modifyPolicy", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminPolicyVO> selectBoardList(AdminPolicyVO vo) {
		return sqlSessionTemplate.selectList("AdminPolicyDAO.selectBoardList");
	}
}
