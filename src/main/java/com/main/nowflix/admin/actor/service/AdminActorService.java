package com.main.nowflix.admin.actor.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.actor.vo.AdminActorVO;
import com.main.nowflix.admin.director.vo.AdminDirectorVO;

public interface AdminActorService {
	List<AdminActorVO> getActorList(HashMap<String, Object> map);
	List<AdminActorVO> getActorListWithoutPaging(AdminActorVO vo);
	int getTotalCount(HashMap<String, Object> map);
	AdminActorVO getActorModifyInfo(AdminActorVO vo);
	AdminActorVO getActorDetail(AdminActorVO vo);
	int deleteActor(AdminActorVO vo);
	int insertActor(AdminActorVO vo);
	int modifyActor(AdminActorVO vo);
	
	int createPdf(String newpdf);	//PDF 
	List<AdminActorVO> selectBoardList() throws Exception; //EXCEL 
}
