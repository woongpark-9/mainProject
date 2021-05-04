package com.main.nowflix.client.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.nowflix.client.member.vo.MemberVO;
import com.main.nowflix.client.movie.service.MovieService;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.profile.service.ProfileService;
import com.main.nowflix.client.profile.vo.ProfileVO;
import com.main.nowflix.client.watch.service.WatchService;
import com.main.nowflix.client.watch.vo.WatchVO;

@Controller
@SessionAttributes("member")
//@SessionAttributes("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private WatchService watchService;

	@RequestMapping("/index.do")
	public String getMovieList(MovieVO vo, Model model, ProfileVO profile, WatchVO watch_id) throws Exception {
		String page = "";
		ProfileVO getpro = profileService.getProfile(profile);
		model.addAttribute("profile", getpro);
		model.addAttribute("profileVO", getpro);

		if (getpro.getGenre_name().equals("N")) {
			return page = "forward:favoriteNew.do";
		} else {
			page = "/views/member/index";
		}

		System.out.println("Controller 작동");
		System.out.println("profile_id : " + profile.getProfile_id());
		System.out.println(getpro);
		// 전체 영화 리스트
		watch_id.setProfile_id(getpro.getProfile_id());
		List<WatchVO> watchList = watchService.getWatchList(watch_id);
		List<MovieVO> movieList = movieService.getMovieList(vo);
//		ProfileVO profile = profileService.getProfile(member);
		movieService.getSelectMovieList(vo, movieList, model, getpro.getGenre_name(), watchList);
		model.addAttribute("profile", getpro);
		return page;
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
//	      ProfileVO addProfileVO = (ProfileVO)model.getAttribute("profileVO");

		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model 정보저장
		model.addAttribute("member", member);
		return "/views/member/favorite_genre"; // View 정보저장
	}

	@RequestMapping("/favoriteNew.do")
	public String getMovieGenreList(MovieVO vo, Model model, @RequestAttribute("profileVO") ProfileVO addProfileVO,
			HttpSession session) {

		MemberVO member = (MemberVO) session.getAttribute("member");
//	      ProfileVO addProfileVO = (ProfileVO)model.getAttribute("profileVO");
		System.out.println("favorite.do 에 바인딩된 프로파일VO" + addProfileVO);

		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model 정보저장
		model.addAttribute("member", member);
//	      model.addAttribute("addProfileVO", addProfileVO);
		return "/views/member/favorite_genre"; // View 정보저장
	}

}