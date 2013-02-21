package com.expedia.lux.model;

import java.sql.Date;

public class Team {

	   private Integer id;
	   private String teamName;
	   private String manager;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	   
	   
}
