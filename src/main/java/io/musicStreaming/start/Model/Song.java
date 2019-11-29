package io.musicStreaming.start.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {

	@Id @GeneratedValue
	private Long id;
	private String title;
	private int artistId;
	private int albumId;
	private String url;
	
	public Song() {}
	
	public Song(Long id, String title, int artistId, int albumId, String url) {
		super();
		this.id = id;
		this.title = title;
		this.artistId = artistId;
		this.albumId = albumId;
		this.url = url;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
