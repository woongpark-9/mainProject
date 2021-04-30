package com.main.nowflix.admin.dashboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Repository
public class AdminDashBoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

//	public List<AdminMovieVO> get_all_movie_count(AdminMovieVO vo) {
//		System.out.println("DAO 작동 ---> MyBatis로 get_all_movie_count() 기능 처리");
//		return sqlSessionTemplate.selectList("AdminMovieDAO.get_all_movie_count", vo);
//	}
	
//	public int get_all_movie_count(AdminMovieVO vo) {
//		System.out.println("DashBoardDAO" + "DAO 작동 ---> MyBatis로 get_all_movie_count() 기능 처리");
//		int result = sqlSessionTemplate.selectOne("AdminMovieDAO.get_all_movie_count", vo);
//		return result;
//	}
}
