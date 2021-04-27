package com.main.nowflix.client.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.player.service.PlayerService;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/getPlayer.do")
	public ModelAndView getPlayer(MovieVO movieVO, ModelAndView mav ) {
		System.out.println("영화 플레이어로 이동 controller");
		mav.addObject("movie", playerService.getMovie(movieVO));
		mav.setViewName("views/player/player");
		
		return mav;
	}
}
