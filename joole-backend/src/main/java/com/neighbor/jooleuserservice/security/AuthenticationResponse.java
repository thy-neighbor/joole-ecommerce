package com.neighbor.jooleuserservice.security;

import java.util.Date;

public class AuthenticationResponse {
	private final String jwt;
	private final int id;
	private final String email;
	//private final Date joinDate;
	private final String role;
	private final String image;
	private final Date tokenExpire;
	
	public AuthenticationResponse(String jwt, int id, String email, String role, String image) {
		Date today= new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 30));		//there is something wrong with this
		this.jwt = jwt;
		this.id = id;
		this.email = email;
		this.role = role;
		this.image=image;
		this.tokenExpire = today;		//there is something wrong with this
	}
	
	public String getJwt() {
		return jwt;
	}

	public Date getTokenExpire() {
		return tokenExpire;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}


	public String getRole() {
		return role;
	}

	public String getImage() {
		return image;
	}
	
	
}
