package io.musicStreaming.start.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDataTransferObject{

    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String matchedPassword;
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
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchedPassword() {
		return matchedPassword;
	}
	public void setMatchedPassword(String matchedPassword) {
		this.matchedPassword = matchedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    
}