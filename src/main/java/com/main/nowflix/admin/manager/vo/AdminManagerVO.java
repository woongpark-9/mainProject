package com.main.nowflix.admin.manager.vo;

import java.sql.Date;

public class AdminManagerVO {

	private int manager_id;
	private String manager_pass;
	private String manager_type;
	private Date manager_regdate;
	private String manager_email;
	private int rownum;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pass() {
		return manager_pass;
	}
	public void setManager_pass(String manager_pass) {
		this.manager_pass = manager_pass;
	}
	public String getManager_type() {
		return manager_type;
	}
	public void setManager_type(String manager_type) {
		this.manager_type = manager_type;
	}
	public Date getManager_regdate() {
		return manager_regdate;
	}
	public void setManager_regdate(Date manager_regdate) {
		this.manager_regdate = manager_regdate;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
}
