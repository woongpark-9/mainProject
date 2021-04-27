package com.main.nowflix.admin.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;



@Controller
public class AdminMovieController {
	
	@Autowired
	private AdminMovieService movieService;
	
	//영화 관리 페이지
	@RequestMapping("/manage_movie.mdo")
	public String getMovie(AdminMovieVO vo, Model model) {
		model.addAttribute("movieList", movieService.getMovieList(vo)); //Model 정보저장
		return "manage_movie";
	}
	
	//영화 삭제
	@ResponseBody
	@RequestMapping("/movieDelete.mdo")
	public int deleteMovie(AdminMovieVO vo) {
		int result = movieService.deleteMovie(vo); //삭제한 행의 개수
		return result;
	}
	
	//영화 추가
	@ResponseBody
	@RequestMapping("/movieInsert.mdo")
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieController load for inserting movie");
		int result = movieService.insertMovie(vo); //추가된 행의 개수(영화 개수) 반환
		return result;
	}
	
	//영화 수정 페이지
	@RequestMapping("/movie_Modify.mdo")
	public String getMovieModify(AdminMovieVO vo, Model model) {
		model.addAttribute("movieModifyInfo", movieService.getMovieModifyInfo(vo)); //Model 정보저장
		return "movie_insert";
	}
	
	//영화 수정
	@ResponseBody
	@RequestMapping("/movieModify.mdo")
	public int modifyMovie(AdminMovieVO vo) {
		int result = movieService.modifyMovie(vo); //Model 정보저장
		return result;
	}
}























