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
		System.out.println("DAO �۵� ---> MyBatis�� getMovieList() ��� ó��");
		return sqlSessionTemplate.selectList("MovieDAO.getMovieList", vo);
	}

	public MovieVO getMovie(MovieVO vo) {
		System.out.println("dao getMoive�۵�");
		return sqlSessionTemplate.selectOne("MovieDAO.getMoive", vo);
	}

	public List<MovieVO> searchMovieList(MovieVO vo) {
		System.out.println("DAO �۵� ---> MyBatis�� searchMovieList() ��� ó��");
		return sqlSessionTemplate.selectList("MovieDAO.searchMovieList", vo);
	}

}