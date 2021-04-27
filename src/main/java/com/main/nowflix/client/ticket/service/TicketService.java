package com.main.nowflix.client.ticket.service;

import java.util.List;



import com.main.nowflix.client.ticket.vo.TicketVO;

public interface TicketService {
	//  �Ϲ�Ƽ�ϸ���Ʈ �޼���			 Ȱ��ȭ �ǰ� , ��õƼ���� �ƴϰ� �̸��� ? �� Ƽ�ϸ���Ʈ�� �������� �޼��� 
	public List<TicketVO> getNormalTicketList(TicketVO vo) throws Exception;
	
	//	��õƼ�ϸ���Ʈ �޼���			 Ȱ��ȭ �ǰ� , ��õƼ���̸� �̸��� ? �� Ƽ�ϸ���Ʈ�� �������� �޼���
	public List<TicketVO> getRecommendTicketList(TicketVO vo)throws Exception;
	
	// Ƽ�ϸ���Ʈ �޼���
	public List<TicketVO> getTicketList(TicketVO vo)throws Exception;  

}
