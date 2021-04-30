package com.main.nowflix.admin.faq.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.faq.vo.AdminFaqVO;

public interface AdminFaqService {
	List<AdminFaqVO> getFaqList(HashMap<String, Object> map);
	int getTotalCount(HashMap<String, Object> map);
	int insertFaq(AdminFaqVO vo);
	int deleteFaq(AdminFaqVO vo);
	int modifyFaq(AdminFaqVO vo);
	List<AdminFaqVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
}
