package com.ecom.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Buyer {
	
	
	private int Byyerid ;
	private String username ;
	private String password ;
	private String emailid ;
	public int getId() {
		return Byyerid;
	}
	public void setId(int id) {
		this.Byyerid = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


}
