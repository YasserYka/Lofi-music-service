package io.musicStreaming.start.controller;

import io.musicStreaming.start.exception.SongNotFoundException;
import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.repository.SongsRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongController {

	private final SongsRepository repository;

	public SongController(SongsRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/songs")
	public String getSongs(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "home";
	}

	@GetMapping("/song/{id}")
	public String getSong(Model model, @PathVariable Long id) {
		model.addAttribute("song", repository.findById(id).orElseThrow(() ->new SongNotFoundException(id)));
		return "play";
	}
	
}