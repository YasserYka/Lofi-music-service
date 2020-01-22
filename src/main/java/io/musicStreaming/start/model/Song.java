package io.musicStreaming.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, name="Title")
	private String title;
	@Column(nullable = false, name="Artist_Id")
	private int artistId;
	@Column(nullable = false, name="Album_Id")
	private int albumId;
	@Column(nullable = false, name="Audio_Url")
	private String audioUrl;
	@Column(nullable = false, name="Image_Url")
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
}
