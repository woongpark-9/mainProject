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
	public void getSelectMovieList(MovieVO vo,List<MovieVO> movieList,Model model) {
		
		//��ü ��ȭ ����Ʈ
		movieList = getMovieList(vo);
		
		// �̱� ��ȭ ����Ʈ
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>();
		
		// �������� ����Ʈ
		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>(12);

		String[] selectGenre = { "�׼�", "����", "�θǽ�", "�θǽ�", "�ִϸ��̼�" };

		// 0 ~ ����ڰ� �� ��ȭ�� �帣 ���� ���� ����
		while(true) {
			// 0 ���� 36 ������ �������� ��
			int result = (int)(Math.random()*37);
			System.out.println(result);
			if(result == 36) {
				break;
			}
		}

		System.out.println("--------------------------");

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

		System.out.println("����ڰ� �� ��ȭ�迭�� ���� : " + selectGenre.length);

		for (MovieVO movie : favoriteMovieList) {
			System.out.println(movie.getTitle());
		}

		// ������ ��ȭ ����Ʈ

		// ���� ��ȭ ����Ʈ
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>();

		// �θǽ� ��ȭ ����Ʈ
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>();

		

		// �̱� + ȣ�� ��ȭ ����Ʈ
		List<MovieVO> usaHorrorMovieList = new ArrayList<MovieVO>();

		// �ִϸ��̼�
		List<MovieVO> animationList = new ArrayList<MovieVO>();

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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		model.addAttribute("usaMovieList",usaMovieList);
		
		
		
		
		
	}
	
	
	
	
}