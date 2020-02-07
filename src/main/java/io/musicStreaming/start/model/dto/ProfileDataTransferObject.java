package io.musicStreaming.start.model.dto;

import io.musicStreaming.start.model.User;

public class ProfileDataTransferObject {

	private String username;
	private String name;
	private String imageUrl;
	private String signupDate;
	
	public ProfileDataTransferObject() {}
	
	//Takes User object and takes fields of interest 
	public ProfileDataTransferObject map(User user) {
		username = user.getUsername();
		name = user.getName();
		imageUrl = user.getImageUrl();
		signupDate = user.getSignupDate();
		return this;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
	
	
}
