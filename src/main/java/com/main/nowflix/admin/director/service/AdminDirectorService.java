package com.main.nowflix.admin.director.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.actor.vo.AdminActorVO;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;
import com.main.nowflix.admin.genre.vo.AdminGenreVO;

public interface AdminDirectorService {
	List<AdminDirectorVO> getDirectorList(HashMap<String, Object> map);
	List<AdminDirectorVO> getDirectorListWithoutPaging(AdminDirectorVO vo);	
	int getTotalCount(HashMap<String, Object> map);
	int insertDirector(AdminDirectorVO vo);
	int deleteDirector(AdminDirectorVO vo);
	int modifyDirector(AdminDirectorVO vo);
	List<AdminDirectorVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
}
