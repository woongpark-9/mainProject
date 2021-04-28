package com.main.nowflix.client.sales.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesVO {

	private  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public SalesVO() {

		// TODO Auto-generated constructor stub
	}

	public SalesVO(String sales_id, String cid, String tid, String email, String ticket_id, String sales_status,
			Date payment_date, Date expiry_date, String payment_method_type, String card_name) {

		this.sales_id = sales_id;
		this.cid = cid;
		this.tid = tid; 
		this.email = email;
		this.ticket_id = ticket_id;
		this.sales_status = sales_status;
		this.payment_date = payment_date;
		this.expiry_date = expiry_date;
		this.payment_method_type = payment_method_type;
		this.card_name = card_name;
	}

	public SalesVO(String sales_id, String cid, String tid, String email, String ticket_id, String sales_status,
			Date payment_date, Date expiry_date, String payment_method_type) {

		this.sales_id = sales_id;
		this.cid = cid;
		this.tid = tid; 
		this.email = email;
		this.ticket_id = ticket_id;
		this.sales_status = sales_status;
		this.payment_date = payment_date;
		this.expiry_date = expiry_date;
		this.payment_method_type = payment_method_type;
	
	}
	
	
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

}
