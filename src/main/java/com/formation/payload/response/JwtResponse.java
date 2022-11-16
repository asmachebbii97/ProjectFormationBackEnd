package com.formation.payload.response;
import java.util.List;

import javax.persistence.Lob;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String fname;
	private String lname;
	@Lob
	private String image;



	private List<String> roles;



	public JwtResponse(String token, Long id, String username, String email, String fname,
			String lname, String image, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.image = image;
		this.roles = roles;
	}
	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getType() {
		return type;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}

	public String getImage() {
		return image;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

}


