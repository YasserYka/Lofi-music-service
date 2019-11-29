package io.musicStreaming.start.controller.Song;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("songs")
public class SongController {

	@GetMapping
	public List<Song> getSongs() {
		return null;
	}
	
	@RequestMapping("songs/{id}")
	public Song getSong() {
		return null;
	}
}
