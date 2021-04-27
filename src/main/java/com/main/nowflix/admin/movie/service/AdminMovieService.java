package com.main.nowflix.admin.movie.service;

import java.util.List;

import com.main.nowflix.admin.movie.vo.AdminMovieVO;

public interface AdminMovieService {
	List<AdminMovieVO> getMovieList(AdminMovieVO vo);
	AdminMovieVO getMovieModifyInfo(AdminMovieVO vo);
	int deleteMovie(AdminMovieVO vo);
	int insertMovie(AdminMovieVO vo);
	int modifyMovie(AdminMovieVO vo);
}
