package com.main.nowflix.client.genre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.genre.dao.GenreDAO;
import com.main.nowflix.client.genre.vo.GenreVO;
import com.main.nowflix.client.member.vo.MemberVO;

@Service("genreService")
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreDAO dao;
	
	@Override
	public int memberGenreCheck(MemberVO vo) throws Exception {
		int result = dao.memberGenreCheck(vo);
		return result;  
	}

}
