package com.main.nowflix.client.movie.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.main.nowflix.client.movie.dao.MovieDAO;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.watch.vo.WatchVO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO movieDAO;

	@Override
	public List<MovieVO> getMovieList(MovieVO vo) {
		System.out.println("ServiceImpl 작동");
		return movieDAO.getMovieList(vo);

	}

	@Override
	public List<MovieVO> searchMovieList(MovieVO vo) {
		return movieDAO.searchMovieList(vo);
	}

	@Override
	public void getSelectMovieList(MovieVO vo, List<MovieVO> movieList, Model model, String getGenre_name,
			List<WatchVO> watchList) {

		// 전체 영화 리스트
		movieList = getMovieList(vo);

		// 미국 영화 리스트
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>();

		// 공포 영화 리스트
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>();

		// 로맨스 영화 리스트
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>();

		// 한국영화 리스트
		List<MovieVO> koreaMovieList = new ArrayList<MovieVO>();

		// 애니메이션
		List<MovieVO> animationList = new ArrayList<MovieVO>();

		// 액션 영화 리스트
		List<MovieVO> actionMovieList = new ArrayList<MovieVO>();

		// 취향저격 리스트
		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>();

		// SF 영화 리스트
		List<MovieVO> sfMovieList = new ArrayList<MovieVO>();

		//
		List<MovieVO> watchMovieList = new ArrayList<MovieVO>();

		String[] selectGenre = getGenre_name.split(",");

		// 0 ~ 사용자가 고른 영화의 장르 수의 난수 생성
		for (int j = 0; j < movieList.size(); j++) {
			int index = (int) (Math.random() * selectGenre.length);
//			System.out.println(index);
//			System.out.println(selectGenre[index]);
			if (movieList.get(j).getGenre_name().contains(selectGenre[index])) {

				if (favoriteMovieList.size() > 24) {
					break;
				}
				favoriteMovieList.add(movieList.get(j));
			}
		}

		// 시청한 영화 뽑기
		for (int i = 0; i < watchList.size(); i++) {
			for (int j = 0; j < movieList.size(); j++) {
				if (movieList.get(j).getSeq() == watchList.get(i).getMovie_id()) {
					watchMovieList.add(movieList.get(j));
					break;
				}
			}
		}

//		// 전체 영화 수 만큼 돌려서 장르가 공포에 해당하는 영화가 있으면 공포영화리스트에 넣어준다

		for (int j = 0; j < movieList.size(); j++) {
			// 만약 전체 영화의 장르가 공포라면 horrorMovieList에 넣어준다

			if (movieList.get(j).getGenre_name().contains("로맨스")) {

				romanceMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getCountry().equals("미국")) {
				if (usaMovieList.size() < 24) {
					usaMovieList.add(movieList.get(j));
				}

			}
			if (movieList.get(j).getGenre_name().contains("애니메이션")) {
				animationList.add(movieList.get(j));
			}

			if (movieList.get(j).getCountry().equals("한국")) {
				if (koreaMovieList.size() < 24) {
					koreaMovieList.add(movieList.get(j));
				}
			}
			if (movieList.get(j).getGenre_name().contains("액션")) {
				if (actionMovieList.size() < 24) {
					actionMovieList.add(movieList.get(j));
				}
			}
			if (movieList.get(j).getGenre_name().contains("SF")) {
				sfMovieList.add(movieList.get(j));
			}

		}

		model.addAttribute("movieList", movieList);
		model.addAttribute("favoriteMovieList", favoriteMovieList);
		model.addAttribute("usaMovieList", usaMovieList);
		model.addAttribute("koreaMovieList", koreaMovieList);
		model.addAttribute("animationList", animationList);
		model.addAttribute("romanceMovieList", romanceMovieList);
		model.addAttribute("horrorMovieList", horrorMovieList);
		model.addAttribute("actionMovieList", actionMovieList);
		model.addAttribute("watchMovieList", watchMovieList);
		model.addAttribute("watchList", watchList);
		model.addAttribute("sfMovieList", sfMovieList);
	}

	@Override
	public List<MovieVO> getRecentList(List<MovieVO> movieList, Model model) {
		Date nowdate = new Date(System.currentTimeMillis());
//	      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	      String now_date = format.format(nowdate);
		List<MovieVO> recentList = new ArrayList<MovieVO>();
		List recentDate = new ArrayList();
		String content = "";

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getRegist_date() == null) {

			} else {
				long day = ((nowdate.getTime()) - movieList.get(i).getRegist_date().getTime()) / (24 * 60 * 60 * 1000);
				if (day <= 3) {
					recentList.add(movieList.get(i));
					if (day == 0) {
						content = "오늘";
						recentDate.add(content);
					} else {
						content = String.valueOf(day) + "일 전";
						recentDate.add(content);
					}
				}
			}
		}

		model.addAttribute("recentDate", recentDate);

		return recentList;
	}

	@Override
	public MovieVO getMainMovie(List<MovieVO> movieList, MovieVO movieVO) {
		List<MovieVO> mainList = new ArrayList<MovieVO>();

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getIs_main().equals("Y")) {
				mainList.add(movieList.get(i));
			}
		}

		int j = (int) (Math.random() * mainList.size());
		movieVO = mainList.get(j);

		System.out.println("메인 무비" + movieVO.toString());

		return movieVO;
	}

}