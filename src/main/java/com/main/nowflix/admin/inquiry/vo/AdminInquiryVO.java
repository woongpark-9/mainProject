package com.main.nowflix.admin.inquiry.vo;

import java.sql.Date;

public class AdminInquiryVO {

	private int inquiry_id;
	private String email;
	private String manager_email;
	private String inquiry_type;
	private String inquiry_title;
	private String inquiry_content;
	private String reply_title;
	private String reply_content;
	private Date inquiry_date;
	private Date reply_date;
	private String check_flag;
	private int rownum;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManager_email() {
		return manager_email;
	}

	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}

	public String getInquiry_type() {
		return inquiry_type;
	}

	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public String getReply_title() {
		return reply_title;
	}

	public void setReply_title(String reply_title) {
		this.reply_title = reply_title;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getInquiry_date() {
		return inquiry_date;
	}

	public void setInquiry_date(Date inquiry_date) {
		this.inquiry_date = inquiry_date;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getCheck_flag() {
		return check_flag;
	}

	public void setCheck_flag(String check_flag) {
		this.check_flag = check_flag;
	}

}
