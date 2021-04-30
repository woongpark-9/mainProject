package com.main.nowflix.admin.policy.service;

import java.util.HashMap;
import java.util.List;

import com.main.nowflix.admin.policy.vo.AdminPolicyVO;

public interface AdminPolicyService {
	List<AdminPolicyVO> getPolicyList(HashMap<String, Object> map);
	int getTotalCount(HashMap<String, Object> map);
	int insertPolicy(AdminPolicyVO vo);
	int deletePolicy(AdminPolicyVO vo);
	int modifyPolicy(AdminPolicyVO vo);
	List<AdminPolicyVO> selectBoardList() throws Exception; //EXCEL 
	int createPdf(String newpdf);	//PDF 
}
