package com.main.nowflix.admin.genre.service;

import java.util.List;

import com.main.nowflix.admin.genre.vo.AdminGenreVO;

public interface AdminGenreService {
	List<AdminGenreVO> getGenreList();
	AdminGenreVO getGenreModifyInfo(AdminGenreVO vo);
	int deleteGenre(AdminGenreVO vo);
	int insertGenre(AdminGenreVO vo);
	int modifyGenre(AdminGenreVO vo);
	int createPdf(String newpdf);	//PDF 
	List<AdminGenreVO> selectBoardList() throws Exception; //EXCEL 
}
