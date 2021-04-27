package com.main.nowflix.client.movie.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.movie.vo.MovieVO;

@Repository
public class MovieDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<MovieVO> getMovieList(MovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 getMovieList() 기능 처리");
		return sqlSessionTemplate.selectList("MovieDAO.getMovieList", vo);
	}

	public MovieVO getMovie(MovieVO vo) {
		System.out.println("dao getMoive작동");
		return sqlSessionTemplate.selectOne("MovieDAO.getMoive", vo);
	}

	public List<MovieVO> searchMovieList(MovieVO vo) {
		System.out.println("DAO 작동 ---> MyBatis로 searchMovieList() 기능 처리");
		return sqlSessionTemplate.selectList("MovieDAO.searchMovieList", vo);
	}

}