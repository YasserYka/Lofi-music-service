package io.musicStreaming.start.Exception;

public class SongNotFoundException extends RuntimeException{

	public SongNotFoundException(Long id) {
		super("Song with id " + id + " not found!");
	}
}
