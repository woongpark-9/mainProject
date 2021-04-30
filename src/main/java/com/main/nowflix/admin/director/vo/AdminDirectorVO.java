package com.main.nowflix.admin.director.vo;

import java.sql.Date;

public class AdminDirectorVO {
	private int director_id;
	private String director_name;
	private Date director_birthdate;
	private String searchCondition;
	private String searchKeyword;
	
	public int getDirector_id() {
		return director_id;
	}
	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public Date getDirector_birthdate() {
		return director_birthdate;
	}
	public void setDirector_birthdate(Date director_birthdate) {
		this.director_birthdate = director_birthdate;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "AdminDirectorVO [director_id=" + director_id + ", director_name=" + director_name
				+ ", director_birthdate=" + director_birthdate + ", searchCondition=" + searchCondition
				+ ", searchKeyword=" + searchKeyword + "]";
	}
}
