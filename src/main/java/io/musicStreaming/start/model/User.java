package io.musicStreaming.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(nullable = false, name="Username")
	private String username;
	@Column(nullable = true, name="Name")
	private String name;
	@Column(nullable = true, name="Plan")
	private String plan;
	@Column(nullable = true, name="Image_Url")
	private String imageUrl;
	@Column(nullable = true, name="Email")
	private String email;
	@Column(nullable = false, name="Password")
	private String password;
	@Column(nullable = true, name="Phone_Number")
	private String phoneNumber;
	@Column(nullable = true, name="Signup_Date")
	private String signupDate;
	@Column(nullable = false, name="Enabled")
	private boolean enabled;
	@Column(nullable = true, name="Roles")
	private String Roles;
	
	
	public User() {}
	
	public User(int id, String name, String username, String plan, String imageUrl, String email, String password,
			String phoneNumber, String signupDate, String sessionToken) {
		super();
		this.name = name;
		this.username = username;
		this.plan = plan;
		this.imageUrl = imageUrl;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.signupDate = signupDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
}
