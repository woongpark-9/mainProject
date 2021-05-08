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
		System.out.println("DAO 작동 ---> MyBatis로 getGenreList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminGenreDAO.getGenreList", map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("DAO 작동 ---> MyBatis로 getTotalCount() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminGenreDAO.getTotalCount", map);
	}

	public int deleteGenre(AdminGenreVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteGenre() 기능 처리");
		return sqlSessionTemplate.delete("AdminGenreDAO.deleteGenre", vo);
	}

	public int insertGenre(AdminGenreVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertGenre() 기능 처리");
		return sqlSessionTemplate.insert("AdminGenreDAO.insertGenre", vo);
	}

	public AdminGenreVO getGenreModifyInfo(AdminGenreVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getGenreModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminGenreDAO.getGenreModifyInfo", vo);
	}

	public int modifyGenre(AdminGenreVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 modifyGenre() 기능 처리");
		return sqlSessionTemplate.update("AdminGenreDAO.modifyGenre", vo);
	}
	
	//PDF,EXCEL 둘중하나 (주석고쳐야함)
	public List<AdminGenreVO> selectBoardList(AdminGenreVO vo) {
		return sqlSessionTemplate.selectList("AdminGenreDAO.selectBoardList");
	}

	public List<AdminGenreVO> getGenreList2(AdminGenreVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getGenreList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminGenreDAO.getGenreList2");
	}

		
	
}