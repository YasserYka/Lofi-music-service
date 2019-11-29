package io.musicStreaming.start.controller.Song;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class SongController {

	@GetMapping
	public List<Song> getSongs() {
		return null;
	}
	
	@GetMapping("/{id}")
	public Song getSong(@PathVariable Long id) {
		//find 
		return null;
	}
}
