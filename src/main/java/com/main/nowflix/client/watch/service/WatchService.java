package com.main.nowflix.client.watch.service;

import java.util.List;

import com.main.nowflix.client.watch.vo.WatchVO;

public interface WatchService {
	//  �Ϲ�Ƽ�ϸ���Ʈ �޼���			 Ȱ��ȭ �ǰ� , ��õƼ���� �ƴϰ� �̸��� ? �� Ƽ�ϸ���Ʈ�� �������� �޼��� 
	public WatchVO getWatchVo(WatchVO vo) throws Exception;
	public void updateWatch(WatchVO vo) throws Exception;
	public void insertWatch(WatchVO vo) throws Exception;
	public List<WatchVO> getWatchList(WatchVO vo) throws Exception;
}
