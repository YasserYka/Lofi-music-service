package io.musicStreaming.start.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.musicStreaming.start.validators.ivalid.IMatch;

@IMatch(first = "password", second="matchingPassword")
public class UserDataTransferObject{

    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
	@NotEmpty
	@Size(min=6, max=50)
    private String username;
    @NotNull
	@NotEmpty
	@Size(min=6, max=50)
    private String password;
    @NotNull
    @NotEmpty
    private String matchingPassword;
	@Email
    @NotNull
	@NotEmpty
	@Size(min=5, max=50)
    private String email;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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