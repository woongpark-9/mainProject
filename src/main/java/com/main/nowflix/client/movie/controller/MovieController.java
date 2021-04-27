package com.main.nowflix.client.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.movie.service.MovieService;
import com.main.nowflix.client.movie.vo.MovieVO;

@Controller
@SessionAttributes("member")
//@SessionAttributes("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	
	@RequestMapping("/index.do")
	public String getBoardList(MovieVO vo, Model model) {
		System.out.println("Controller 작동");
		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model 정보저장
		return "/views/member/index"; // View 정보저장
	}
	
	
	@ResponseBody
    @RequestMapping("/search.do")
    public List<MovieVO> getSearchMovie(MovieVO vo) {
       System.out.println(movieService.searchMovieList(vo));
       return movieService.searchMovieList(vo);
    }

	
	
}