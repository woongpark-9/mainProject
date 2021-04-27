package com.main.nowflix.admin.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.admin.movie.dao.AdminMovieDAO;
import com.main.nowflix.admin.movie.vo.AdminMovieVO;

@Service("adminMovieService")
public class AdminMovieServiceImpl implements AdminMovieService {
	@Autowired
	private AdminMovieDAO movieDAO;
	
	//영화 리스트 가져오기
	@Override
	public List<AdminMovieVO> getMovieList(AdminMovieVO vo) {
		return movieDAO.getMovieList(vo);
	}
	
	//영화 삭제 
	@Override
	public int deleteMovie(AdminMovieVO vo) {
		return movieDAO.deleteMovie(vo);
	}
	
	//영화 추가
	@Override
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for inserting movie");
		return movieDAO.insertMovie(vo);
	}

	//영화 수정 정보 가져오기
	@Override
	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for getting modifying movie info");
		return movieDAO.getMovieModifyInfo(vo);
	}

	//영화 수정
	@Override
	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for modifying movie");
		return movieDAO.modifyMovie(vo);
	}
}
