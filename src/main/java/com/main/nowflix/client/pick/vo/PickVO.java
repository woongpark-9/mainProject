package com.main.nowflix.client.pick.vo;

public class PickVO {
	private int pick_id;	//Pick¿« pk
	private int seq;		//movie¿« pk
	private int profile_id;
	private String status;
	
	
	
	public PickVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public PickVO(int profile_id) {
		super();
		this.profile_id = profile_id;
	}

	public PickVO(int seq, int profile_id, String status) {
		super();
		this.seq = seq;
		this.profile_id = profile_id;
		this.status = status;
	}
	
	
	public int getPick_id() {
		return pick_id;
	}
	public void setPick_id(int pick_id) {
		this.pick_id = pick_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Pick [pick_id=" + pick_id + ", seq=" + seq + ", profile_id=" + profile_id + ", status=" + status
				+ ", getPick_id()=" + getPick_id() + ", getSeq()=" + getSeq() + ", getProfile_id()=" + getProfile_id()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
