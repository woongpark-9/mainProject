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
//		System.out.println("DAO �۵� ---> MyBatis�� get_all_movie_count() ��� ó��");
//		return sqlSessionTemplate.selectList("AdminMovieDAO.get_all_movie_count", vo);
//	}
	
//	public int get_all_movie_count(AdminMovieVO vo) {
//		System.out.println("DashBoardDAO" + "DAO �۵� ---> MyBatis�� get_all_movie_count() ��� ó��");
//		int result = sqlSessionTemplate.selectOne("AdminMovieDAO.get_all_movie_count", vo);
//		return result;
//	}
}
