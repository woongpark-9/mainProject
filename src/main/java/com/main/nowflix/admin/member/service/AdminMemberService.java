package com.main.nowflix.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.member.vo.AdminMemberVO;

public interface AdminMemberService {
//	public int get_all_member_count(AdminMemberVO memberVO);	//DASHBOARD에 회원 수 

	// 멤버 관리 페이지 service
	int getTotalCount(HashMap<String, Object> map); // Total Count

	List<AdminMemberVO> getMemberList(HashMap<String, Object> map); // member List

	// 멤버 추가 , 수정 , 수정 페이지
	int insertMember(AdminMemberVO memberVO); // 추가

	AdminMemberVO getMemberModifyInfo(AdminMemberVO membervo); // 수정 페이지

	int modifyMember(AdminMemberVO memberVO); // 수정

	// 문서화작업 service
	int membercreatePdf(String newmemberpdf); // PDF

	List<AdminMemberVO> selectBoardList() throws Exception; // EXCEL

	ArrayList<Integer> ageList(AdminMemberVO membervo, AdminAnalysis_Age_VO analysis_age_VO);

}
