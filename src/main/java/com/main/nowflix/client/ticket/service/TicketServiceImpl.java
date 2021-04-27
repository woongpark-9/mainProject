package com.main.nowflix.client.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.ticket.dao.TicketDAO;
import com.main.nowflix.client.ticket.vo.TicketVO;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDAO dao;	
	
	
	@Override
	public List<TicketVO> getNormalTicketList(TicketVO vo) throws Exception {
		return dao.getNormalTicketList(vo);

	}


	@Override
	public List<TicketVO> getRecommendTicketList(TicketVO vo) throws Exception {
		return dao.getRecommendTicketList(vo);
	}


	@Override
	public List<TicketVO> getTicketList(TicketVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.getTicketList(vo);
	}

}
