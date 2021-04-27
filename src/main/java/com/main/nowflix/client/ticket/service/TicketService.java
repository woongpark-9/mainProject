package com.main.nowflix.client.ticket.service;

import java.util.List;



import com.main.nowflix.client.ticket.vo.TicketVO;

public interface TicketService {
	//  일반티켓리스트 메서드			 활성화 되고 , 추천티켓이 아니고 이름이 ? 인 티켓리스트를 가져오는 메서드 
	public List<TicketVO> getNormalTicketList(TicketVO vo) throws Exception;
	
	//	추천티켓리스트 메서드			 활성화 되고 , 추천티켓이며 이름이 ? 인 티켓리스트를 가져오는 메서드
	public List<TicketVO> getRecommendTicketList(TicketVO vo)throws Exception;
	
	// 티켓리스트 메서드
	public List<TicketVO> getTicketList(TicketVO vo)throws Exception;  

}
