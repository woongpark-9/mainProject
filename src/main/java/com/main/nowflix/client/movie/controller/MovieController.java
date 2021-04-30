package com.main.nowflix.client.movie.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@Controller
@SessionAttributes("member")
//@SessionAttributes("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping("/index.do")
	public String getMovieList(MovieVO vo, Model model) {
		System.out.println("Controller 작동");
		// 전체 영화 리스트
		List<MovieVO> movieList = movieService.getMovieList(vo);
		movieService.getSelectMovieList(vo, movieList, model);
		
//		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>(12);
//
//		String[] selectGenre = { "액션", "공포", "로맨스", "로맨스", "애니메이션" };
//
//		// 0 ~ 사용자가 고른 영화의 장르 수의 난수 생성
//		while(true) {
//			// 0 부터 36 까지의 난수생성 예
//			int result = (int)(Math.random()*37);
//			System.out.println(result);
//			if(result == 36) {
//				break;
//			}
//		}

//		System.out.println("--------------------------");
//
//		for (int j = 0; j < movieList.size(); j++) {
//			int index = (int) (Math.random() * selectGenre.length);
//			System.out.println(index);
////				System.out.println(selectGenre[index]);
//			if (movieList.get(j).getGenre_name().contains(selectGenre[index])) {
//				System.out.println(movieList.get(j).getGenre_name());
//				System.out.println(selectGenre[index]);
//				favoriteMovieList.add(movieList.get(j));
//
//			}
//
//		}
//
//		System.out.println("사용자가 고른 영화배열의 길이 : " + selectGenre.length);
//
//		for (MovieVO movie : favoriteMovieList) {
//			System.out.println(movie.getTitle());
//		}

		// 스릴러 영화 리스트

		// 공포 영화 리스트
//		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>();
//
//		// 로맨스 영화 리스트
//		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>();
//
//		
//
//		// 미국 + 호러 영화 리스트
//		List<MovieVO> usaHorrorMovieList = new ArrayList<MovieVO>();
//
//		// 애니메이션
//		List<MovieVO> animationList = new ArrayList<MovieVO>();
//
////		// 전체 영화 수 만큼 돌려서 장르가 공포에 해당하는 영화가 있으면 공포영화리스트에 넣어준다
//
//		for (int j = 0; j < movieList.size(); j++) {
//			// 만약 전체 영화의 장르가 공포라면 horrorMovieList에 넣어준다
//			if (movieList.get(j).getGenre_name().contains("공포")) {
//				if (movieList.get(j).getCountry().equals("미국")) {
//					usaHorrorMovieList.add(movieList.get(j));
//				}
//
//				horrorMovieList.add(movieList.get(j));
//			}
//			if (movieList.get(j).getGenre_name().contains("로맨스")) {
//				romanceMovieList.add(movieList.get(j));
//			}
//			if (movieList.get(j).getCountry().equals("미국")) {
//				usaMovieList.add(movieList.get(j));
//			}
//			if (movieList.get(j).getGenre_name().contains("애니메이션")) {
//				animationList.add(movieList.get(j));
//			}
//
//		}
//
//		for (MovieVO movie : horrorMovieList) {
//			System.out.print(movie.getTitle() + " ");
//		}
//
//		for (MovieVO movie : usaHorrorMovieList) {
//			System.out.print(movie.getTitle() + " 미국호러");
//		}
//
//		for (MovieVO movie : animationList) {
//			System.out.print(movie.getTitle() + " 애니메이션");
//		}

		return "/views/member/index"; // View 정보저장
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
		model.addAttribute("movieList", movieService.getMovieList(vo)); // Model 정보저장
		model.addAttribute("member", member);

		return "/views/member/favorite_genre"; // View 정보저장
	}

}