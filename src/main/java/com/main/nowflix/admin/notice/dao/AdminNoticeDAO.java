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

	// �������� ����Ʈ ��������
	public List<AdminNoticeVO> getNoticeList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getNoticeList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminNoticeDAO.getNoticeList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminNoticeDAO.getTotalCount", map);
	}

	// �������� �߰�
	public int insertNotice(AdminNoticeVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertNotice() ��� ó��");
		return sqlSessionTemplate.insert("AdminNoticeDAO.insertNotice", vo);
	}

	// �������� ����
	public int deleteNotice(AdminNoticeVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteNotice() ��� ó��");
		return sqlSessionTemplate.delete("AdminNoticeDAO.deleteNotice", vo);
	}

	// �������� ����
	public int modifyNotice(AdminNoticeVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� modifyNotice() ��� ó��");
		return sqlSessionTemplate.update("AdminNoticeDAO.modifyNotice", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminNoticeVO> selectBoardList(AdminNoticeVO vo) {
		return sqlSessionTemplate.selectList("AdminNoticeDAO.selectBoardList");
	}
}
