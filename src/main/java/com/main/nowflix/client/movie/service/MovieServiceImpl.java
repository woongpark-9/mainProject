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
		System.out.println("ServiceImpl �۵�");
		return movieDAO.getMovieList(vo);

	}

	@Override
	public List<MovieVO> searchMovieList(MovieVO vo) {
		return movieDAO.searchMovieList(vo);
	}

	@Override
	public void getSelectMovieList(MovieVO vo, List<MovieVO> movieList, Model model, String getGenre_name,
			List<WatchVO> watchList) {

		// ��ü ��ȭ ����Ʈ
		movieList = getMovieList(vo);

		// �̱� ��ȭ ����Ʈ
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>(30);

		// ���� ��ȭ ����Ʈ
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>(30);

		// �θǽ� ��ȭ ����Ʈ
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>(30);

		// �̱� + ȣ�� ��ȭ ����Ʈ
		List<MovieVO> usaHorrorMovieList = new ArrayList<MovieVO>(30);
		
		// �ܱ���ȭ ����Ʈ
		List<MovieVO> foreignMovieList = new ArrayList<MovieVO>(30);
		
		// �ѱ���ȭ ����Ʈ
		List<MovieVO> koreaMovieList = new ArrayList<MovieVO>(30);

		// �ִϸ��̼�
		List<MovieVO> animationList = new ArrayList<MovieVO>(30);
		
		//�׼� ��ȭ ����Ʈ
		List<MovieVO> actionMovieList = new ArrayList<MovieVO>(30);

		// �������� ����Ʈ
		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>(12);
		
		//
		List<MovieVO> watchMovieList = new ArrayList<MovieVO>();
		
		System.out.println(getGenre_name);
		String[] selectGenre = getGenre_name.split(",");
		for (String genre : selectGenre) {
			System.out.print(genre);
		}

		// 0 ~ ����ڰ� �� ��ȭ�� �帣 ���� ���� ����
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
		

//		// ��ü ��ȭ �� ��ŭ ������ �帣�� ������ �ش��ϴ� ��ȭ�� ������ ������ȭ����Ʈ�� �־��ش�

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
			if(!movieList.get(j).getCountry().equals("�ѱ�")) {
				foreignMovieList.add(movieList.get(j));
			}
			if(movieList.get(j).getCountry().equals("�ѱ�")) {
				koreaMovieList.add(movieList.get(j));
			}
			if(movieList.get(j).getGenre_name().contains("�׼�")) {
				actionMovieList.add(movieList.get(j));
			}
		

		}
		System.out.println("�������� : ");
		for(MovieVO movie : favoriteMovieList) {
			System.out.println(movie.getTitle());
		}
		System.out.println();
		
		System.out.println("�̱� : ");
		for(MovieVO movie : usaMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�ѱ� : ");
		for(MovieVO movie : koreaMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�ִϸ��̼� : ");
		for(MovieVO movie : animationList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�ܱ� : ");
		for(MovieVO movie : foreignMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�θǽ� : ");
		for(MovieVO movie : romanceMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("ȣ�� : ");
		for(MovieVO movie : horrorMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�̱�ȣ�� : ");
		for(MovieVO movie : usaHorrorMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("�׼� : ");
		for(MovieVO movie : actionMovieList) {
			System.out.print(movie.getTitle());
		}
		System.out.println();
		System.out.println("���� ��û�� ��ȭ: ");
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