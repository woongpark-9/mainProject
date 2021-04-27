package com.main.nowflix.client.ticket.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.nowflix.client.ticket.vo.TicketVO;

@Repository
public class TicketDAO {
	@Autowired
	private SqlSession sql;
	
	public List<TicketVO> getNormalTicketList(TicketVO vo) {
		System.out.println("dao getNormalTicketList 실행");
		return sql.selectList("ticketMapper.getNormalTicketList", vo);
	}
	
	public List<TicketVO> getRecommendTicketList(TicketVO vo){
		System.out.println("dao getRecommendTicketList 실행");
		return sql.selectList("ticketMapper.getRecommendTicketList",vo);
	}
	
	public List<TicketVO> getTicketList(TicketVO vo) {
		System.out.println("dao getTicketList 실행");
		return sql.selectList("ticketMapper.getTicketList",vo);
	}
}


