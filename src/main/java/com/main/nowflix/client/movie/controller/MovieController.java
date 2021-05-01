package com.main.nowflix.client.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.movie.service.MovieService;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.service.ProfileService;
import com.main.nowflix.client.profile.vo.ProfileVO;

@Controller
@SessionAttributes("member")
//@SessionAttributes("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	
	@Autowired
	private ProfileService profileService;
	
	
	
	@RequestMapping("/index.do")
	public String getMovieList(MovieVO vo, Model model,ProfileVO profile) throws Exception {
		System.out.println("Controller �۵�");
		System.out.println("profile_id : " + profile.getProfile_id());
		ProfileVO getpro = profileService.getProfile(profile);
		// ��ü ��ȭ ����Ʈ
		List<MovieVO> movieList = movieService.getMovieList(vo);
//		ProfileVO profile = profileService.getProfile(member);
		movieService.getSelectMovieList(vo, movieList, model,getpro.getGenre_name());
		model.addAttribute("profile", getpro);
		return "/views/member/index"; // View ��������
	}

	@ResponseBody
	@RequestMapping("/search.do")
	public List<MovieVO> getSearchMovie(MovieVO vo) {
		System.out.println(movieService.searchMovieList(vo));
		return movieService.searchMovieList(vo);
	}

	@RequestMapping("/favorite.do")
	public String getMovieGenreList(MovieVO vo, Model model, HttpSession session) {

		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model ��������
		model.addAttribute("member", member);

		return "/views/member/favorite_genre"; // View ��������
	}

}