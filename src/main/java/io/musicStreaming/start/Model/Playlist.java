package io.musicStreaming.start.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Playlist {
	
	@Id @GeneratedValue
	private int id;
	private int userId;
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
