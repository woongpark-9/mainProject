package com.main.nowflix.client.genre.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.main.nowflix.client.member.vo.MemberVO;

@Repository
public class GenreDAO {
	@Autowired
	private SqlSession sql;
	
	public int memberGenreCheck(MemberVO vo) throws Exception{
		int result = sql.selectOne("genreMapper.memberGenreCheck",vo);
		return result;
	}
	
}
