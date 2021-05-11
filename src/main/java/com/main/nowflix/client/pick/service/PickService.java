package com.main.nowflix.client.pick.service;

import java.util.List;

import com.main.nowflix.client.movie.vo.MovieVO;
import com.main.nowflix.client.pick.vo.PickVO;
import com.main.nowflix.client.profile.vo.ProfileVO;

public interface PickService {
	public String setPick(String seq, String profile_id, String pick);
	public List<MovieVO> getPickMovieList(ProfileVO profileVO, MovieVO movieVO);
	public List<PickVO> getPickList(ProfileVO profileVO);
}
