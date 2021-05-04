package com.main.nowflix.admin.genre.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.genre.vo.AdminGenreVO;

public interface AdminGenreService {
	List<AdminGenreVO> getGenreList(HashMap<String, Object> map);

	int getTotalCount(HashMap<String, Object> map);

	AdminGenreVO getGenreModifyInfo(AdminGenreVO vo);

	int deleteGenre(AdminGenreVO vo);

	int insertGenre(AdminGenreVO vo);

	int modifyGenre(AdminGenreVO vo);

	int createPdf(String newpdf); // PDF

	List<AdminGenreVO> selectBoardList() throws Exception; // EXCEL
}
