package com.main.nowflix.admin.notice.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.notice.vo.AdminNoticeVO;

public interface AdminNoticeService {
	List<AdminNoticeVO> getNoticeList(HashMap<String, Object> map);
	int getTotalCount(HashMap<String, Object> map);
	int insertNotice(AdminNoticeVO vo);
	int deleteNotice(AdminNoticeVO vo);
	int modifyNotice(AdminNoticeVO vo);
	List<AdminNoticeVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
}
