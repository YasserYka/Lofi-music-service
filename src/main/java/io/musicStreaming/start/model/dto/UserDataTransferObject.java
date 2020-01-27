package io.musicStreaming.start.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.musicStreaming.start.validation.valid.ValidEmail;
import io.musicStreaming.start.validation.valid.PasswordMatches;

@PasswordMatches
public class UserDataTransferObject{

    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String matchingPassword;
	@ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    
}