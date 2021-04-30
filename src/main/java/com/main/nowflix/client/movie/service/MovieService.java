package com.main.nowflix.client.movie.service;

import java.util.List;

import org.springframework.ui.Model;

import com.main.nowflix.client.movie.vo.MovieVO;

public interface MovieService {
	List<MovieVO> getMovieList(MovieVO vo);
	List<MovieVO> searchMovieList(MovieVO vo);
	void getSelectMovieList(MovieVO vo,List<MovieVO> movieList,Model model);
}
 