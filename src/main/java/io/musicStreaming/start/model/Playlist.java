package io.musicStreaming.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Playlist {
	
	@Id @GeneratedValue
	@Column(nullable = false, name="Id")
	private int id;
	@Column(nullable = false, name="User_Id")
	private int userId;
	@Column(nullable = false, name="Title")
	private String title;
	
	public Playlist() {}

	public Playlist(int id, int userId, String title) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
