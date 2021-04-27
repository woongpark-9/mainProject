package com.main.nowflix.admin.movie.vo;

public class AdminMovieVO {
	private String movie_path;
	private int seq;
	private String title;
	private String director;
	private String genre1;
	private String genre2;
	private String movie_runningtime;
	private String movie_release_date;
	private String movie_rating;
	private String summary;
	private String country;
	private String teaser_path;
	private String poster_path;
	private String is_active;
	private String is_main;
	private String subtitle;
	private String actor;
	
	
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
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
	public String getTeaser_path() {
		return teaser_path;
	}
	public void setTeaser_path(String teaser_path) {
		this.teaser_path = teaser_path;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
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
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
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
	
	@Override
	public String toString() {
		return "AdminMovieVO [movie_path=" + movie_path + ", seq=" + seq + ", title=" + title + ", director=" + director
				+ ", genre1=" + genre1 + ", genre2=" + genre2 + ", movie_runningtime=" + movie_runningtime
				+ ", movie_release_date=" + movie_release_date + ", movie_rating=" + movie_rating + ", summary="
				+ summary + ", country=" + country + ", teaser_path=" + teaser_path + ", poster_path=" + poster_path
				+ ", is_active=" + is_active + ", is_main=" + is_main + ", subtitle=" + subtitle + ", actor=" + actor
				+ "]";
	}
}
