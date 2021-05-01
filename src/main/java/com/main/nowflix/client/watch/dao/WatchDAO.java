package com.main.nowflix.client.watch.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.watch.vo.WatchVO;

@Repository
public class WatchDAO {
	@Autowired
	private SqlSession sql;
	
	public WatchVO getWatchVo(WatchVO vo) {
		return sql.selectOne("watchMapper.getWatchVO", vo);
	}
	
	public int updateWatch(WatchVO vo) {
		sql.update("watchMapper.updateWatch", vo);
		return 0;
	}
}


