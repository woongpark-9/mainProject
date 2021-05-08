package com.main.nowflix.admin.analysis.vo;

public class AdminAnalysis_Director_count_VO {
	private String director_name;
	private int count;
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdminAnalysis_Director_count_VO [director_name=" + director_name + ", count=" + count + "]";
	}
	
	
	
	
}
