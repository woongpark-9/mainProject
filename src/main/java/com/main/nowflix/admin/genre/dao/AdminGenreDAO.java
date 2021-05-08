package com.main.nowflix.admin.genre.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.director.vo.AdminDirectorVO;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;

@Repository
public class AdminGenreDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<AdminGenreVO> getGenreList(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getGenreList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminGenreDAO.getGenreList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO �۵� ---> MyBatis�� getTotalCount() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminGenreDAO.getTotalCount", map);
	}

	public int deleteGenre(AdminGenreVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� deleteGenre() ��� ó��");
		return sqlSessionTemplate.delete("AdminGenreDAO.deleteGenre", vo);
	}

	public int insertGenre(AdminGenreVO vo) {
		System.out.println("DAO�۵� ---> MyBatis�� insertGenre() ��� ó��");
		return sqlSessionTemplate.insert("AdminGenreDAO.insertGenre", vo);
	}

	public AdminGenreVO getGenreModifyInfo(AdminGenreVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getGenreModifyInfo() ��� ó��");
		return sqlSessionTemplate.selectOne("AdminGenreDAO.getGenreModifyInfo", vo);
	}

	public int modifyGenre(AdminGenreVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� modifyGenre() ��� ó��");
		return sqlSessionTemplate.update("AdminGenreDAO.modifyGenre", vo);
	}
	
	//PDF,EXCEL �����ϳ� (�ּ����ľ���)
	public List<AdminGenreVO> selectBoardList(AdminGenreVO vo) {
		return sqlSessionTemplate.selectList("AdminGenreDAO.selectBoardList");
	}

	public List<AdminGenreVO> getGenreList2(AdminGenreVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� getGenreList() ��� ó��");
		return sqlSessionTemplate.selectList("AdminGenreDAO.getGenreList2");
	}

		
	
}