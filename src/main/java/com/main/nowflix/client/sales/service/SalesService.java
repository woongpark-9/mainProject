package com.main.nowflix.client.sales.service;

import java.util.List;

import com.main.nowflix.client.sales.vo.SalesVO;

public interface SalesService {
	//�������� db�� insert�ϴ� �޼���
	public void insertSalesInfo(SalesVO vo) throws Exception;

	public List<SalesVO> getSalesInfo(SalesVO vo)throws Exception;
}
