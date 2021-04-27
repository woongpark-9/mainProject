package com.main.nowflix.client.genre.vo;

public class GenreVO {
	private int genre_id;
	private String genre_name;
	private String email;
	
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", genre_name=" + genre_name + ", email=" + email + "]";
	}
	
	
}
