package com.main.nowflix.client.watch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.watch.dao.WatchDAO;
import com.main.nowflix.client.watch.vo.WatchVO;
@Service
public class WatchServiceImpl implements WatchService {
	@Autowired
	private WatchDAO dao;	


	@Override
	public WatchVO getWatchVo(WatchVO vo) throws Exception {
		System.out.println(vo.toString());
		WatchVO getVO = dao.getWatchVo(vo);
		if(getVO == null) {
			dao.insertWatch(vo);
		}
		return dao.getWatchVo(vo);
	}


	@Override
	public void updateWatch(WatchVO vo) throws Exception {
		dao.updateWatch(vo);
	}


	@Override
	public void insertWatch(WatchVO vo) throws Exception {
		dao.insertWatch(vo);		
	}


	@Override
	public List<WatchVO> getWatchList(WatchVO vo) throws Exception {
		return dao.getWatchList(vo);
	}
}