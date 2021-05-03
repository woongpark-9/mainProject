package com.main.nowflix.client.movie.service;

import java.util.List;

import org.springframework.ui.Model;

import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.watch.vo.WatchVO;

public interface MovieService {
	List<MovieVO> getMovieList(MovieVO vo);
	List<MovieVO> searchMovieList(MovieVO vo);
	void getSelectMovieList(MovieVO vo,List<MovieVO> movieList,Model model,String getGenre_name,List<WatchVO> watchList);
	
}

 