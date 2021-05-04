package com.main.nowflix.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.analysis.vo.AdminAnalysis_Age_VO;
import com.main.nowflix.admin.member.vo.AdminMemberVO;

public interface AdminMemberService {
//	public int get_all_member_count(AdminMemberVO memberVO);	//DASHBOARD�� ȸ�� �� 

	// ��� ���� ������ service
	int getTotalCount(HashMap<String, Object> map); // Total Count

	List<AdminMemberVO> getMemberList(HashMap<String, Object> map); // member List

	// ��� �߰� , ���� , ���� ������
	int insertMember(AdminMemberVO memberVO); // �߰�

	AdminMemberVO getMemberModifyInfo(AdminMemberVO membervo); // ���� ������

	int modifyMember(AdminMemberVO memberVO); // ����

	// ����ȭ�۾� service
	int membercreatePdf(String newmemberpdf); // PDF

	List<AdminMemberVO> selectBoardList() throws Exception; // EXCEL

	ArrayList<Integer> ageList(AdminMemberVO membervo, AdminAnalysis_Age_VO analysis_age_VO);

}
