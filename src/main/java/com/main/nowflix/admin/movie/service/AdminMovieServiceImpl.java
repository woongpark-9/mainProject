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
	
	//��ȭ ����Ʈ ��������
	@Override
	public List<AdminMovieVO> getMovieList(AdminMovieVO vo) {
		return movieDAO.getMovieList(vo);
	}
	
	//��ȭ ���� 
	@Override
	public int deleteMovie(AdminMovieVO vo) {
		return movieDAO.deleteMovie(vo);
	}
	
	//��ȭ �߰�
	@Override
	public int insertMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for inserting movie");
		return movieDAO.insertMovie(vo);
	}

	//��ȭ ���� ���� ��������
	@Override
	public AdminMovieVO getMovieModifyInfo(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for getting modifying movie info");
		return movieDAO.getMovieModifyInfo(vo);
	}

	//��ȭ ����
	@Override
	public int modifyMovie(AdminMovieVO vo) {
		System.out.println("AdminMovieServiceImpl load for modifying movie");
		return movieDAO.modifyMovie(vo);
	}
}
