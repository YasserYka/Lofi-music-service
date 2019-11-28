package io.musicStreaming.start.controller.Song;

//@Entity
//@Table(name = "SONG")
public class Song {

	//@Id @GeneratedValue
	//@Column(name ="id")
	private int id;
	//@Column(name ="title")
	private String title;
	//@Column(name ="artistId")
	private int artistId;
	//@Column(name ="albumId")
	private int albumId;
	//@Column(name ="url")
	private String url;
	
	public Song() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
