package io.musicStreaming.start.exception;

public class SongNotFoundException extends RuntimeException{

	public SongNotFoundException(Long id) {
		super("Song with id " + id + " not found!");
	}
}
