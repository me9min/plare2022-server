package org.amel.plare.vo;

import lombok.Getter;
import lombok.Setter;


public class GamePlayerVO {

    private int id;
    private String authid;
	private int credits;
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthid() {
		return authid;
	}
	public void setAuthid(String authid) {
		this.authid = authid;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
    
    
}
