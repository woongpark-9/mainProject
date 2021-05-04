package com.main.nowflix.admin.manager.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.manager.vo.AdminManagerVO;
import com.main.nowflix.admin.manager.vo.AdminManagerVO;

public interface AdminManagerService {

	List<AdminManagerVO> getManagerList(HashMap<String, Object> map);
	int getTotalCount(HashMap<String, Object> map);
	int insertManager(AdminManagerVO vo);
	int deleteManager(AdminManagerVO vo);
	int modifyManager(AdminManagerVO vo);
	AdminManagerVO adminLogin(AdminManagerVO vo) throws Exception;
	List<AdminManagerVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
}		
