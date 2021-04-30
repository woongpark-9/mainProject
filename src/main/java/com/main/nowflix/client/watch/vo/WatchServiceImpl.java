package com.main.nowflix.client.watch.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.watch.dao.WatchDAO;
import com.main.nowflix.client.watch.service.WatchService;
@Service
public class WatchServiceImpl implements WatchService {
	@Autowired
	private WatchDAO dao;	


	@Override
	public WatchVO getWatchVo(WatchVO vo) throws Exception {
		return dao.getWatchVo(vo);
	}
}