package com.main.nowflix.admin.actor.vo;

import java.sql.Date;

public class AdminActorVO {
	private int actor_id;
	private String actor_name;
	private Date actor_birth;

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getActor_name() {
		return actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}

	public Date getActor_birth() {
		return actor_birth;
	}

	public void setActor_birth(Date actor_birth) {
		this.actor_birth = actor_birth;
	}

}
