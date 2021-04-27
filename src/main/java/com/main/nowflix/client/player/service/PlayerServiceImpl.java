package com.main.nowflix.client.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.movie.dao.MovieDAO;
import com.main.nowflix.client.movie.vo.MovieVO;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	MovieDAO movieDAO;
	
	@Override
	public MovieVO getMovie(MovieVO movieVO) {
		System.out.println("PlayerService getMovie()½ÇÇà");
		return movieDAO.getMovie(movieVO);
	}

}
