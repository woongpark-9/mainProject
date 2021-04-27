package com.main.nowflix.client.sales.service;

import com.main.nowflix.client.sales.vo.SalesVO;

public interface SalesService {
	//결제정보 db에 insert하는 메서드
	public void insertSalesInfo(SalesVO vo) throws Exception;
}
