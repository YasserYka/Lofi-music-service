package io.musicStreaming.start.controller.Song;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

	@RequestMapping("/songs")
	public List<Song> getSongs() {
		return null;
	}
}
