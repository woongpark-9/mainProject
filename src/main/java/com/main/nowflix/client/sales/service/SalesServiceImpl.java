package com.main.nowflix.client.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.nowflix.client.sales.dao.SalesDAO;
import com.main.nowflix.client.sales.vo.SalesVO;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesDAO dao;
	
	
	@Override
	public void insertSalesInfo(SalesVO vo) throws Exception {
		dao.insertSalesInfo(vo);
	}


	@Override
	public List<SalesVO> getSalesInfo(SalesVO vo) throws Exception {
		return dao.getSalesInfo(vo);
	}

}
