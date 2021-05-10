package com.main.nowflix.client.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.main.nowflix.client.pick.service.PickService;
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
	
	@Autowired
	private PickService pickService;

	@RequestMapping("/index.do")
	public String getMovieList(MovieVO vo, Model model, ProfileVO profile, WatchVO watch_id, HttpSession session)
			throws Exception {
		String page = "";
		ProfileVO getpro = profileService.getProfile(profile);
		model.addAttribute("profile", getpro);
		model.addAttribute("profileVO", getpro);

		if (getpro.getGenre_name().equals("N")) {
			return page = "forward:favoriteNew.do";
		} else {
			page = "/views/member/index";
		}

		System.out.println("Controller �۵�");
		System.out.println("profile_id : " + profile.getProfile_id());
		System.out.println(getpro);
		// ��ü ��ȭ ����Ʈ
		watch_id.setProfile_id(getpro.getProfile_id());
		List<WatchVO> watchList = watchService.getWatchList(watch_id);
		List<MovieVO> movieList = movieService.getMovieList(vo);
		List<MovieVO> recentList = movieService.getRecentList(movieList, model);
	      
	    //���������� ���� ����
	    MovieVO mainMovie = movieService.getMainMovie(movieList, vo);
		movieService.getSelectMovieList(vo, movieList, model, getpro.getGenre_name(), watchList);
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<ProfileVO> profileList = profileService.getProfileList(getpro, member);

		model.addAttribute("profileList", profileList);
		model.addAttribute("member", member);
		model.addAttribute("profile", getpro);
		model.addAttribute("recentList", recentList);
	    model.addAttribute("mainMovie", mainMovie);
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

		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model ��������
		model.addAttribute("member", member);
		return "/views/member/favorite_genre"; // View ��������
	}

	@RequestMapping("/favoriteNew.do")
	public String getMovieGenreList(MovieVO vo, Model model, @RequestAttribute("profileVO") ProfileVO addProfileVO,
			HttpSession session) {

		MemberVO member = (MemberVO) session.getAttribute("member");
//	      ProfileVO addProfileVO = (ProfileVO)model.getAttribute("profileVO");
		System.out.println("favorite.do �� ���ε��� ��������VO" + addProfileVO);

		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model ��������
		model.addAttribute("member", member);
		return "/views/member/favorite_genre"; // View ��������
	}
	
	
	@ResponseBody
	   @RequestMapping("/pickUpdate.do")
	   public String pickUpdate(ProfileVO ProfileVO, MovieVO movieVO, HttpServletRequest request) {
	      System.out.println("pickUpdate.do ����");
	      System.out.println("�Ⱦ�����Ʈ �� ��" +request.getParameter("pick"));
	      System.out.println("�Ⱦ�����Ʈ �� ��" +request.getParameter("profile_id"));
	      System.out.println("�Ⱦ�����Ʈ �� ��" +request.getParameter("seq"));
	      System.out.println(movieVO);
	      String pick = request.getParameter("pick");
	      String profile_id = request.getParameter("profile_id");
	      String seq = request.getParameter("seq");
	      
	      
	      return pickService.setPick(seq, profile_id, pick );
	   }
	   
	   @RequestMapping("/pick.do")
	   public String getPickMovieList(ProfileVO profileVO, Model model, MovieVO movieVO) {
	      
	      System.out.println("pick.do�� profileVO" + profileVO.toString());
	      
	      List<MovieVO> pickMovieList = new ArrayList<MovieVO>();
	      pickMovieList =   pickService.getPickMovieList(profileVO, movieVO);
	   
	      model.addAttribute("pickMovieList", pickMovieList);
	      
	      return "/views/member/pick";
	   }

}