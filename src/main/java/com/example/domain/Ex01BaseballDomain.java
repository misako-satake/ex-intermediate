package com.example.domain;


public class Ex01BaseballDomain {

	private Integer id;
	private String league_name;
	private String team_name;
	private String headquarters;
	private String inauguration;
	private String history;
	
	
	@Override
	public String toString() {
		return "Ex01BaseballDomain [id=" + id + ", league_name=" + league_name + ", team_name=" + team_name
				+ ", headquarters=" + headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	

	
}
