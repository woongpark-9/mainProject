package com.main.nowflix.client.profile.vo;

public class ProfileVO {
	private int profile_id;
	private String email;
	private String profile_name;
	private int horror;
	private int comic;
	private int action;
	private String kids;
	private String profile_img;
	
	
	public String getKids() {
		return kids;
	}
	public void setKids(String kids) {
		this.kids = kids;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public int getHorror() {
		return horror;
	}
	public void setHorror(int horror) {
		this.horror = horror;
	}
	public int getComic() {
		return comic;
	}
	public void setComic(int comic) {
		this.comic = comic;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	
	
	
	
}
