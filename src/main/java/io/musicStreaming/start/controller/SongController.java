package io.musicStreaming.start.controller;

import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.service.FileService;
import io.musicStreaming.start.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

	@Autowired
	private SongService songService;
	
	@Autowired
	FileService fileService;


	@GetMapping("/songs")
	public String getSongs(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
		Page<Song> songs = songService.songsList(size, page);
		
		model.addAttribute("songs", songs.getContent());		
		model.addAttribute("totalPages", songs.getTotalPages() - 1);
		model.addAttribute("size", songs.getSize());
		
		return "home";
	}


	@GetMapping("/song/{id}")
	public String getSong(Model model, @PathVariable Long id) {
		model.addAttribute("song", songService.findById(id));
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
		
		songService.saveSong(title, artistName, image, audio);
		
		fileService.uploadFileOfKind(audio, "audio");
		fileService.uploadFileOfKind(image, "image");
		
		return "redirect:/uploadStatus";
	}

	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {return "uploadStatus";}
	
}