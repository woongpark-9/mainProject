package com.main.nowflix.admin.ticket.vo;

public class AdminTicketVO {
	private int seq;
	private String ticket_id;
	private String ticket_name;
	private int ticket_period;
	private int ticket_price;
	private String ticket_status;
	private String ticket_recommend;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	public int getTicket_period() {
		return ticket_period;
	}

	public void setTicket_period(int ticket_period) {
		this.ticket_period = ticket_period;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

	public String getTicket_recommend() {
		return ticket_recommend;
	}

	public void setTicket_recommend(String ticket_recommend) {
		this.ticket_recommend = ticket_recommend;
	}

}