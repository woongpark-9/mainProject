package com.main.nowflix.client.watch.service;

import com.main.nowflix.client.watch.vo.WatchVO;

public interface WatchService {
	//  일반티켓리스트 메서드			 활성화 되고 , 추천티켓이 아니고 이름이 ? 인 티켓리스트를 가져오는 메서드 
	public WatchVO getWatchVo(WatchVO vo) throws Exception;
	public void updateWatch(WatchVO vo) throws Exception;
}
