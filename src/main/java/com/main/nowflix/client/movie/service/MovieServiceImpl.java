package com.main.nowflix.client.movie.service;

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
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>(30);

		// 공포 영화 리스트
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>(30);

		// 로맨스 영화 리스트
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>(30);

		// 미국 + 호러 영화 리스트
		List<MovieVO> usaHorrorMovieList = new ArrayList<MovieVO>(30);
		
		// 외국영화 리스트
		List<MovieVO> foreignMovieList = new ArrayList<MovieVO>(30);
		
		// 한국영화 리스트
		List<MovieVO> koreaMovieList = new ArrayList<MovieVO>(30);

		// 애니메이션
		List<MovieVO> animationList = new ArrayList<MovieVO>(30);
		
		//액션 영화 리스트
		List<MovieVO> actionMovieList = new ArrayList<MovieVO>(30);

		// 취향저격 리스트
		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>(12);
		
		//
		List<MovieVO> watchMovieList = new ArrayList<MovieVO>();
		
		System.out.println(getGenre_name);
		String[] selectGenre = getGenre_name.split(",");
		for (String genre : selectGenre) {
			System.out.print(genre);
		}

		// 0 ~ 사용자가 고른 영화의 장르 수의 난수 생성
		for (int j = 0; j < movieList.size(); j++) {
			int index = (int) (Math.random() * selectGenre.length);
			System.out.println(index);
			System.out.println(selectGenre[index]);
			if (movieList.get(j).getGenre_name().contains(selectGenre[index])) {
				System.out.println(movieList.get(j).getGenre_name());
				System.out.println(selectGenre[index]);
				favoriteMovieList.add(movieList.get(j));
			}
		}
		
		for(int i =0; i<watchList.size(); i++) {
			for(int j =0; j<movieList.size(); j++) {
				if(movieList.get(j).getSeq() == watchList.get(i).getMovie_id()) {
					watchMovieList.add(movieList.get(j));
					break;
				}
			}
		}
		

//		// 전체 영화 수 만큼 돌려서 장르가 공포에 해당하는 영화가 있으면 공포영화리스트에 넣어준다

		for (int j = 0; j < movieList.size(); j++) {
			// 만약 전체 영화의 장르가 공포라면 horrorMovieList에 넣어준다
			if (movieList.get(j).getGenre_name().contains("공포")) {
				if (movieList.get(j).getCountry().equals("미국")) {
					usaHorrorMovieList.add(movieList.get(j));
				}
				horrorMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getGenre_name().contains("로맨스")) {
				romanceMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getCountry().equals("미국")) {
				usaMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getGenre_name().contains("애니메이션")) {
				animationList.add(movieList.get(j));
			}
			if(!movieList.get(j).getCountry().equals("한국")) {
				foreignMovieList.add(movieList.get(j));
			}
			if(movieList.get(j).getCountry().equals("한국")) {
				koreaMovieList.add(movieList.get(j));
			}
			if(movieList.get(j).getGenre_name().contains("액션")) {
				actionMovieList.add(movieList.get(j));
			}
		

		}
		System.out.println("취향저격 : ");
		for(MovieVO movie : favoriteMovieList) {
			System.out.println(movie.getTitle());
		}
		System.out.println();
		
		System.out.println("미국 : ");
		for(MovieVO movie : usaMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("한국 : ");
		for(MovieVO movie : koreaMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("애니메이션 : ");
		for(MovieVO movie : animationList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("외국 : ");
		for(MovieVO movie : foreignMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("로맨스 : ");
		for(MovieVO movie : romanceMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("호러 : ");
		for(MovieVO movie : horrorMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("미국호러 : ");
		for(MovieVO movie : usaHorrorMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("액션 : ");
		for(MovieVO movie : actionMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("내가 시청한 영화: ");
		for(MovieVO movie : watchMovieList) {
			System.out.print(movie.getTitle());
		}
		
		model.addAttribute("favoriteMovieList",favoriteMovieList);
		model.addAttribute("usaMovieList", usaMovieList);
		model.addAttribute("koreaMovieList",koreaMovieList);
		model.addAttribute("animationList",animationList);
		model.addAttribute("foreignMovieList",foreignMovieList);
		model.addAttribute("romanceMovieList",romanceMovieList);
		model.addAttribute("horrorMovieList",horrorMovieList);
		model.addAttribute("usaHorrorMovieList",usaHorrorMovieList);
		model.addAttribute("actionMovieList",actionMovieList);
		model.addAttribute("watchMovieList",watchMovieList);
		model.addAttribute("watchList",watchList);
	}


}