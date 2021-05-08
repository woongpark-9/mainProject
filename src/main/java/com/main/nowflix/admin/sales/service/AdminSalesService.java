package com.main.nowflix.admin.sales.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.sales.vo.AdminSalesVO;

public interface AdminSalesService {
	List<AdminSalesVO> getSalesList(HashMap<String, Object> map);
	int getTotalCount(HashMap<String, Object> map);
	List<AdminSalesVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
	
	List<AdminSalesVO> SalesList(AdminSalesVO salesVO);
	List<AdminSalesVO> selectPaymentDataList(AdminSalesVO salesVO);
}
