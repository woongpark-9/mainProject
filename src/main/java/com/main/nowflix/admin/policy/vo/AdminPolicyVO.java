package com.main.nowflix.admin.policy.vo;

import java.sql.Date;

public class AdminPolicyVO {

	private int policy_id;
	private String policy_title;
	private String policy_content;
	private Date policy_regdate;
	private int rownum;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	public String getPolicy_title() {
		return policy_title;
	}
	public void setPolicy_title(String policy_title) {
		this.policy_title = policy_title;
	}
	public String getPolicy_content() {
		return policy_content;
	}
	public void setPolicy_content(String policy_content) {
		this.policy_content = policy_content;
	}
	public Date getPolicy_regdate() {
		return policy_regdate;
	}
	public void setPolicy_regdate(Date policy_regdate) {
		this.policy_regdate = policy_regdate;
	}
}
