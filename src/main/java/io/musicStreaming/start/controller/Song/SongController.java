package io.musicStreaming.start.controller.Song;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

	@RequestMapping("/song")
	public String getSongs() {
		return "Successful!";
	}
}
