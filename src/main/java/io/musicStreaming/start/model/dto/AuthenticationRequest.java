package io.musicStreaming.start.model.dto;

public class AuthenticationRequest {

	private String username;
	private String password;
	
	public AuthenticationRequest() {}
	
	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
