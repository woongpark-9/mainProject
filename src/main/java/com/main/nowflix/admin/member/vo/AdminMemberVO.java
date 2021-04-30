package com.main.nowflix.admin.member.vo;

import java.sql.Date;

public class AdminMemberVO {
	private int seq;
	private String email;
	private String nickname;
	private String birth;
	private int age;
	private String gender;
	private String cert;
	private String ban;
	private String genre;
	private Date join_date;
	private String ticket_id;
	private String kakao;
	private String naver;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getKakao() {
		return kakao;
	}
	public void setKakao(String kakao) {
		this.kakao = kakao;
	}
	public String getNaver() {
		return naver;
	}
	public void setNaver(String naver) {
		this.naver = naver;
	}
	@Override
	public String toString() {
		return "AdminMemberVO [seq=" + seq + ", email=" + email + ", nickname=" + nickname + ", birth=" + birth
				+ ", age=" + age + ", gender=" + gender + ", cert=" + cert + ", ban=" + ban + ", genre=" + genre
				+ ", join_date=" + join_date + ", ticket_id=" + ticket_id + ", kakao=" + kakao + ", naver=" + naver
				+ "]";
	}
	

}
