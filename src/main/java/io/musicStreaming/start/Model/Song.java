package io.musicStreaming.start.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, name="title")
	private String title;
	@Column(nullable = false, name="artist_Id")
	private int artistId;
	@Column(nullable = false, name="album_Id")
	private int albumId;
	@Column(nullable = false, name="Url")
	private String url;

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
