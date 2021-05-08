package com.main.nowflix.admin.sales.vo;

import java.sql.Date;

public class AdminSalesVO {
	private String sales_id;
	private String cid;
	private String tid;
	private String email;
	private String ticket_id;
	private String sales_status;
	private Date payment_date;
	private Date expiry_date;
	private String payment_method_type;
	private String card_name;
	private int rownum;
	private Date date1;
	private Date date2;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getSales_id() {
		return sales_id;
	}
	public void setSales_id(String sales_id) {
		this.sales_id = sales_id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getSales_status() {
		return sales_status;
	}
	public void setSales_status(String sales_status) {
		this.sales_status = sales_status;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getPayment_method_type() {
		return payment_method_type;
	}
	public void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	@Override
	public String toString() {
		return "AdminSalesVO [sales_id=" + sales_id + ", cid=" + cid + ", tid=" + tid + ", email=" + email
				+ ", ticket_id=" + ticket_id + ", sales_status=" + sales_status + ", payment_date=" + payment_date
				+ ", expiry_date=" + expiry_date + ", payment_method_type=" + payment_method_type + ", card_name="
				+ card_name + ", rownum=" + rownum + ", date1=" + date1 + ", date2=" + date2 + ", getRownum()="
				+ getRownum() + ", getSales_id()=" + getSales_id() + ", getCid()=" + getCid() + ", getTid()=" + getTid()
				+ ", getEmail()=" + getEmail() + ", getTicket_id()=" + getTicket_id() + ", getSales_status()="
				+ getSales_status() + ", getPayment_date()=" + getPayment_date() + ", getExpiry_date()="
				+ getExpiry_date() + ", getPayment_method_type()=" + getPayment_method_type() + ", getCard_name()="
				+ getCard_name() + ", getDate1()=" + getDate1() + ", getDate2()=" + getDate2() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
