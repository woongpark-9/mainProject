package com.main.nowflix.client.sales.service;

import java.util.List;

import com.main.nowflix.client.sales.vo.SalesVO;

public interface SalesService {
	//결제정보 db에 insert하는 메서드
	public void insertSalesInfo(SalesVO vo) throws Exception;

	public List<SalesVO> getSalesInfo(SalesVO vo)throws Exception;
}
