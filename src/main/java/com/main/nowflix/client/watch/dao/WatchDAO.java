package com.main.nowflix.client.watch.dao;

import java.util.List;

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
	public void insertWatch(WatchVO vo) {
		sql.insert("watchMapper.insertWatch", vo);
	}
	
	public void updateWatch(WatchVO vo) {
		sql.update("watchMapper.updateWatch", vo);
	}
	public List<WatchVO> getWatchList(WatchVO vo)  {
		return sql.selectList("watchMapper.getWatchList",vo);
	}
}


