package com.expedia.lux.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class KudosData {
	
	 private Integer kudosSentUserId;
	   private Integer kudosRecvdUserId;
	   private Integer id;
	   private String kudosContent;
	   private Date dateSent;
	List<User> users = new ArrayList<User>();
	List<Team> teams = new ArrayList<Team>();
	
	
		
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getKudosSentUserId() {
		return kudosSentUserId;
	}
	public void setKudosSentUserId(Integer kudosSentUserId) {
		this.kudosSentUserId = kudosSentUserId;
	}
	public Integer getKudosRecvdUserId() {
		return kudosRecvdUserId;
	}
	public void setKudosRecvdUserId(Integer kudosRecvdUserId) {
		this.kudosRecvdUserId = kudosRecvdUserId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKudosContent() {
		return kudosContent;
	}
	public void setKudosContent(String kudosContent) {
		this.kudosContent = kudosContent;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	   
	   

}
