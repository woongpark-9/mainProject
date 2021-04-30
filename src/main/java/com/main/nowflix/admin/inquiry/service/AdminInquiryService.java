package com.main.nowflix.admin.inquiry.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.inquiry.vo.AdminInquiryVO;

public interface AdminInquiryService {
	List<AdminInquiryVO> getInquiryList(HashMap<String, Object> map);

	int getTotalCount(HashMap<String, Object> map);

	int insertInquiry(AdminInquiryVO vo);

	int deleteInquiry(AdminInquiryVO vo);

	int modifyInquiry(AdminInquiryVO vo);

	List<AdminInquiryVO> selectBoardList() throws Exception; // EXCEL

	int createPdf(String newpdf); // PDF
}
