package io.musicStreaming.start.Controller;

import io.musicStreaming.start.Repository.SongsRepository;
import io.musicStreaming.start.Model.Song;
import io.musicStreaming.start.Exception.SongNotFoundException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/songs")
public class SongController {

	private final SongsRepository repository;
	private static final String SONGS_PATH = "src/main/resource/songs/";

	public SongController(SongsRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	@ResponseBody
	public List<Song> getSongs() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public String getSong(Model model, @PathVariable Long id) {
		Song song = repository.findById(id).orElseThrow(() ->new SongNotFoundException(id));
		model.addAttribute("title", song.getTitle());
		model.addAttribute("url", song.getUrl());
		return "play";
	}
}
