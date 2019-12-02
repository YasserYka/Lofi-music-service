package io.musicStreaming.start.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id @GeneratedValue
	private int ID;
	@Column(nullable = false)
	private String name;
	private String userName;
	@Column(nullable = false)
	private String plan;
	@Column(nullable = false)
	private String imageUrl;
	private String email;
	private String password;
	@Column(nullable = false)
	private String phoneNumber;
	private Date signupDate;
	@Column(nullable = false)
	private String sessionToken;
	
}
