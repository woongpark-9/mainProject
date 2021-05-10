package com.main.nowflix.client.pick.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.movie.dao.MovieDAO;
import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.pick.dao.PickDAO;
import com.main.nowflix.client.pick.vo.PickVO;
import com.main.nowflix.client.profile.vo.ProfileVO;

@Service
public class PickServiceImpl implements PickService{
	@Autowired
	private PickDAO pickDAO;
	
	@Autowired
	private MovieDAO movieDAO;

	@Override
	public String setPick(String seq, String profile_id, String pick) {
		PickVO pickVO = new PickVO(Integer.parseInt(seq), Integer.parseInt(profile_id), pick);
		String status = "";
		
		if(pickDAO.getPick(pickVO) == null ) {
			pickDAO.insertPick(pickVO);
			status = "Y";
		}else {
			pickDAO.deletePick(pickVO);
			status = "N";
		}
		
		
		System.out.println("pickVO" + pickVO);
		
		return status;
		
	}

	@Override
	public List<MovieVO> getPickMovieList(ProfileVO profileVO, MovieVO movieVO) {
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		movieList = movieDAO.getMovieList(movieVO); // 무비리스트는 가져온다
		
		List<MovieVO> pickMovieList = new ArrayList<MovieVO>();
		
		
		PickVO pickVO = new PickVO(profileVO.getProfile_id());
	
		
		List<PickVO> pickList = new ArrayList<PickVO>();
		pickList = pickDAO.getPickList(pickVO); //프로파일 id가 ? 인 픽업리스트를 가져온다.
		
		for(int i=0; i < movieList.size(); i++) {
			for(int j=0; j < pickList.size(); j++) {
				if(movieList.get(i).getSeq() == pickList.get(j).getSeq()) {
					pickMovieList.add(movieList.get(i));
				
				}
			}
		}
		return pickMovieList;
	}

}
