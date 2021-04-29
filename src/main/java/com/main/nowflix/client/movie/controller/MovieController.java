package com.main.nowflix.client.movie.controller;

import java.util.ArrayList;
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

@Controller
@SessionAttributes("member")
//@SessionAttributes("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping("/index.do")
	public String getMovieList(MovieVO vo, Model model) {
		System.out.println("Controller �۵�");
		// ��ü ��ȭ ����Ʈ
		List<MovieVO> movieList = movieService.getMovieList(vo);

		// ������ ��ȭ ����Ʈ

		// ���� ��ȭ ����Ʈ
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>();

		// �θǽ� ��ȭ ����Ʈ
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>();

		// �̱� ��ȭ ����Ʈ
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>();

		// �̱� + ȣ�� ��ȭ ����Ʈ
		List<MovieVO> usaHorrorMovieList = new ArrayList<MovieVO>();

		// �ִϸ��̼�
		List<MovieVO> animationList = new ArrayList<MovieVO>();

		// ��ü ��ȭ �� ��ŭ ������ �帣�� ������ �ش��ϴ� ��ȭ�� ������ ������ȭ����Ʈ�� �־��ش�

		for (int j = 0; j < movieList.size(); j++) {
			// ���� ��ü ��ȭ�� �帣�� ������� horrorMovieList�� �־��ش�
			if (movieList.get(j).getGenre_name().contains("����")) {
				if (movieList.get(j).getCountry().equals("�̱�")) {
					usaHorrorMovieList.add(movieList.get(j));
				}

				horrorMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getGenre_name().contains("�θǽ�")) {
				romanceMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getCountry().equals("�̱�")) {
				usaMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getGenre_name().contains("�ִϸ��̼�")) {
				animationList.add(movieList.get(j));
			}

		}

		for (MovieVO movie : horrorMovieList) {
			System.out.print(movie.getTitle() + " ");
		}

		for (MovieVO movie : usaHorrorMovieList) {
			System.out.print(movie.getTitle() + " �̱�ȣ��");
		}

		for (MovieVO movie : animationList) {
			System.out.print(movie.getTitle() + " �ִϸ��̼�");
		}

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