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
		List<MovieVO> usaMovieList = new ArrayList<MovieVO>();

		// ���� ��ȭ ����Ʈ
		List<MovieVO> horrorMovieList = new ArrayList<MovieVO>();

		// �θǽ� ��ȭ ����Ʈ
		List<MovieVO> romanceMovieList = new ArrayList<MovieVO>();

		// �ѱ���ȭ ����Ʈ
		List<MovieVO> koreaMovieList = new ArrayList<MovieVO>();

		// �ִϸ��̼�
		List<MovieVO> animationList = new ArrayList<MovieVO>();

		// �׼� ��ȭ ����Ʈ
		List<MovieVO> actionMovieList = new ArrayList<MovieVO>();

		// �������� ����Ʈ
		Set<MovieVO> favoriteMovieList = new HashSet<MovieVO>();

		// SF ��ȭ ����Ʈ
		List<MovieVO> sfMovieList = new ArrayList<MovieVO>();

		//
		List<MovieVO> watchMovieList = new ArrayList<MovieVO>();

		String[] selectGenre = getGenre_name.split(",");

		// 0 ~ ����ڰ� �� ��ȭ�� �帣 ���� ���� ����
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

		// ��û�� ��ȭ �̱�
		for (int i = 0; i < watchList.size(); i++) {
			for (int j = 0; j < movieList.size(); j++) {
				if (movieList.get(j).getSeq() == watchList.get(i).getMovie_id()) {
					watchMovieList.add(movieList.get(j));
					break;
				}
			}
		}

//		// ��ü ��ȭ �� ��ŭ ������ �帣�� ������ �ش��ϴ� ��ȭ�� ������ ������ȭ����Ʈ�� �־��ش�

		for (int j = 0; j < movieList.size(); j++) {
			// ���� ��ü ��ȭ�� �帣�� ������� horrorMovieList�� �־��ش�

			if (movieList.get(j).getGenre_name().contains("�θǽ�")) {

				romanceMovieList.add(movieList.get(j));
			}
			if (movieList.get(j).getCountry().equals("�̱�")) {
				if (usaMovieList.size() < 24) {
					usaMovieList.add(movieList.get(j));
				}

			}
			if (movieList.get(j).getGenre_name().contains("�ִϸ��̼�")) {
				animationList.add(movieList.get(j));
			}

			if (movieList.get(j).getCountry().equals("�ѱ�")) {
				if (koreaMovieList.size() < 24) {
					koreaMovieList.add(movieList.get(j));
				}
			}
			if (movieList.get(j).getGenre_name().contains("�׼�")) {
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
						content = "����";
						recentDate.add(content);
					} else {
						content = String.valueOf(day) + "�� ��";
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

		System.out.println("���� ����" + movieVO.toString());

		return movieVO;
	}

}