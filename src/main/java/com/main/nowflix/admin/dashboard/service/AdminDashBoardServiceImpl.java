package com.main.nowflix.admin.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.admin.dashboard.dao.AdminDashBoardDAO;
import com.main.nowflix.admin.member.vo.AdminMemberVO;
import com.main.nowflix.admin.movie.dao.AdminMovieDAO;
import com.main.nowflix.admin.movie.service.AdminMovieService;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Service("adminDashBoardService")

public class AdminDashBoardServiceImpl implements AdminDashBoardService{
	
	@Autowired
	private AdminDashBoardDAO DashBoardDAO;
	@Autowired
	private AdminMovieDAO AdminMovieDAO;
	
	//영화 리스트 가져오기

//	@Override
//	public List<AdminMovieVO> get_all_movie_count(AdminMovieVO vo) {
//		return DashBoardDAO.get_all_movie_count(vo);
//	}
	

}
