package com.main.nowflix.client.watch.service;

import com.main.nowflix.client.watch.vo.WatchVO;

public interface WatchService {
	//  �Ϲ�Ƽ�ϸ���Ʈ �޼���			 Ȱ��ȭ �ǰ� , ��õƼ���� �ƴϰ� �̸��� ? �� Ƽ�ϸ���Ʈ�� �������� �޼��� 
	public WatchVO getWatchVo(WatchVO vo) throws Exception;
	public void updateWatch(WatchVO vo) throws Exception;
}
