package com.main.nowflix.client.watch.vo;

import java.util.Date;

public class WatchVO {
	private int watch_id;
	private int movie_id;
	private int profile_id;
	private Date watch_date;
	private int view_point;
	public int getWatch_id() {
		return watch_id;
	}
	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public Date getWatch_date() {
		return watch_date;
	}
	public void setWatch_date(Date watch_date) {
		this.watch_date = watch_date;
	}
	public int getView_point() {
		return view_point;
	}
	public void setView_point(int view_point) {
		this.view_point = view_point;
	}
	@Override
	public String toString() {
		return "WatchVO [watch_id=" + watch_id + ", movie_id=" + movie_id + ", profile_id=" + profile_id
				+ ", watch_date=" + watch_date + ", view_point=" + view_point + "]";
	}
	
}
