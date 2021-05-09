package com.main.nowflix.client.movie.vo;

import java.sql.Date;

public class MovieVO {
	private String movie_path;
	private int seq;
	private String title;
	private String director;
	private String movie_runningtime;
	private String movie_release_date;
	private String movie_rating;
	private String summary;
	private String country;
	private String is_active;
	private String is_main;
	private String subtitle;
	private String director_name;
	private String genre_name;
	private String actor_name;
	private Date regist_date;
	@Override
	public String toString() {
		return "MovieVO [movie_path=" + movie_path + ", seq=" + seq + ", title=" + title + ", director=" + director
				+ ", movie_runningtime=" + movie_runningtime + ", movie_release_date=" + movie_release_date
				+ ", movie_rating=" + movie_rating + ", summary=" + summary + ", country=" + country + ", is_active="
				+ is_active + ", is_main=" + is_main + ", subtitle=" + subtitle + ", director_name=" + director_name
				+ ", genre_name=" + genre_name + ", actor_name=" + actor_name + "]";
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public String getMovie_path() {
		return movie_path;
	}
	public void setMovie_path(String movie_path) {
		this.movie_path = movie_path;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMovie_runningtime() {
		return movie_runningtime;
	}
	public void setMovie_runningtime(String movie_runningtime) {
		this.movie_runningtime = movie_runningtime;
	}
	public String getMovie_release_date() {
		return movie_release_date;
	}
	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}
	public String getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(String movie_rating) {
		this.movie_rating = movie_rating;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	public String getIs_main() {
		return is_main;
	}
	public void setIs_main(String is_main) {
		this.is_main = is_main;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof MovieVO) {
//			MovieVO movie = (MovieVO) obj;
//			return movie.subtitle.equals(title) && (movie.seq == seq);
// 		}else {
// 			return false;
// 		}
//		
//	}
	
	
}
