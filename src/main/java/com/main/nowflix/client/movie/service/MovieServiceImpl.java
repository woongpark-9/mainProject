package com.main.nowflix.client.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.main.nowflix.client.movie.dao.MovieDAO;
import com.main.nowflix.client.movie.vo.MovieVO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO movieDAO;
	
	

	@Override
	public List<MovieVO> getMovieList(MovieVO vo) {
		System.out.println("ServiceImpl 작동");
		return movieDAO.getMovieList(vo);
		
		
		
	}

	@Override
	public List<MovieVO> searchMovieList(MovieVO vo) {
		return movieDAO.searchMovieList(vo);
	}

	@Override
	public void getSelectMovieList(MovieVO vo,List<MovieVO> movieList,Model model) {
		
		//전체 영화 리스트
		movieList = getMovieList(vo);
		
		// 미국 영화 리스트
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>();
		
		for (int j = 0; j < movieList.size(); j++) {
			if (movieList.get(j).getCountry().equals("미국")) {
				usaMovieList.add(movieList.get(j));
			}
		} 
		
		model.addAttribute("usaMovieList",usaMovieList);
		
		
		
		
		
	}
	
	
	
	
}