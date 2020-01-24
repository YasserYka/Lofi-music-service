package io.musicStreaming.start.controller;

import io.musicStreaming.start.exception.SongNotFoundException;
import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.repository.SongsRepository;
import io.musicStreaming.start.service.FileService;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

	private final SongsRepository repository;

	@Autowired
	FileService fileService;
	
	public SongController(SongsRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song> listOfSongs = repository.findAll();
		if(listOfSongs != null)
			model.addAttribute("songs", repository.findAll());
		return "home";
	}

	@GetMapping("/song/{id}")
	public String getSong(Model model, @PathVariable Long id) {
		model.addAttribute("song", repository.findById(id).orElseThrow(() ->new SongNotFoundException(id)));
		return "play";
	}
	
	@GetMapping("/upload")
	public String upload(){
		return "upload";
	}

	@PostMapping("/upload")
	public String handleUpload(@RequestParam("audio") MultipartFile audio, @RequestParam("image") MultipartFile image, RedirectAttributes redirect, @RequestParam String title, @RequestParam String artistName) {
		if(audio.isEmpty() || image.isEmpty())
			redirect.addFlashAttribute("message", "Please make sure to upload both audio and image");
		else
			redirect.addFlashAttribute("message", "Thank you for uploading");
		
		Song song = new Song();
		song.setTitle(title);
		song.setArtistName(artistName);
		song.setImageUrl("/images/"+ image.getOriginalFilename());
		song.setAudioUrl("/audio/"+ audio.getOriginalFilename());
		
		repository.save(song);
		
		fileService.uploadFileOfKind(audio, "audio");
		fileService.uploadFileOfKind(image, "image");
		
		return "redirect:/uploadStatus";
	}

	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {return "uploadStatus";}
	
}