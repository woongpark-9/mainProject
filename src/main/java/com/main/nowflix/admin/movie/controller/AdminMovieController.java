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
	
	//��ȭ ���� ������
	@RequestMapping("/manage_movie.mdo")
	public String getMovie(AdminMovieVO vo, Model model) {
		model.addAttribute("movieList", movieService.getMovieList(vo)); //Model ��������
		return "manage_movie";
	}
	
	//��ȭ ����
	@ResponseBody
	@RequestMapping("/movieDelete.mdo")
	public int deleteMovie(AdminMovieVO vo) {
		int result = movieService.deleteMovie(vo); //������ ���� ����
		return result;
	}
	
	//��ȭ �߰�
	@ResponseBody
	@RequestMapping("/movieInsert.mdo")
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieController load for inserting movie");
		int result = movieService.insertMovie(vo); //�߰��� ���� ����(��ȭ ����) ��ȯ
		return result;
	}
	
	//��ȭ ���� ������
	@RequestMapping("/movie_Modify.mdo")
	public String getMovieModify(AdminMovieVO vo, Model model) {
		model.addAttribute("movieModifyInfo", movieService.getMovieModifyInfo(vo)); //Model ��������
		return "movie_insert";
	}
	
	//��ȭ ����
	@ResponseBody
	@RequestMapping("/movieModify.mdo")
	public int modifyMovie(AdminMovieVO vo) {
		int result = movieService.modifyMovie(vo); //Model ��������
		return result;
	}
}























