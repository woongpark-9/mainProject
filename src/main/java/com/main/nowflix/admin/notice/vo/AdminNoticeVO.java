package com.main.nowflix.admin.notice.vo;

import java.sql.Date;

public class AdminNoticeVO {

	private int notice_id;
	private String notice_title;
	private String notice_content;
	private Date notice_regdate;
	private int rownum;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_regdate() {
		return notice_regdate;
	}
	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
}
