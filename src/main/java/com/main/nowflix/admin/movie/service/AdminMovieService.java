package com.main.nowflix.admin.movie.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

public interface AdminMovieService {
	List<AdminMovieVO> getMovieList(HashMap<String, Object> map);

	int getTotalCount(HashMap<String, Object> map);

	AdminMovieVO getMovieModifyInfo(AdminMovieVO vo);

	AdminMovieVO getMovieDetail(AdminMovieVO vo);

	int deleteMovie(AdminMovieVO vo);

	int insertMovie(AdminMovieVO vo);

	int modifyMovie(AdminMovieVO vo);

	int createPdf(String newpdf); // PDF

	List<AdminMovieVO> selectBoardList() throws Exception; // EXCEL

	public int get_all_movie_count(AdminMovieVO movieVO); // DASHBOARD에 회원 수

	ArrayList<Integer> movieList(AdminMovieVO movieVO, AdminAnalysis_Age_VO analysis_age_VO);
}
