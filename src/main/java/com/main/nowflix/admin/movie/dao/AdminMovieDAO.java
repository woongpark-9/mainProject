package com.main.nowflix.admin.movie.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.movie.vo.AdminMovieVO;


@Repository
public class AdminMovieDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<AdminMovieVO> getMovieList(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieList() 기능 처리");
		return sqlSessionTemplate.selectList("AdminMovieDAO.getMovieList", vo);
	}
	
	public int deleteMovie(AdminMovieVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 deleteMovie() 기능 처리");
		return sqlSessionTemplate.delete("AdminMovieDAO.deleteMovie", vo);
	}
	
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("DAO작동 ---> MyBatis로 insertMovie() 기능 처리");
		return sqlSessionTemplate.insert("AdminMovieDAO.insertMovie", vo);
	}
	
	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieModifyInfo() 기능 처리");
		return sqlSessionTemplate.selectOne("AdminMovieDAO.getMovieModifyInfo", vo);
	}
	
	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 modifyMovie() 기능 처리");
		return sqlSessionTemplate.update("AdminMovieDAO.modifyMovie", vo);
	}
}