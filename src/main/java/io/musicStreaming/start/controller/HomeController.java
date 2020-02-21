package io.musicStreaming.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.model.dto.UserDataTransferObject;
import io.musicStreaming.start.model.dto.contactDataTransferObject;
import io.musicStreaming.start.service.FileService;
import io.musicStreaming.start.service.SongService;

@Controller
public class HomeController {

	@Autowired
	private SongService songService;
	
	@Autowired
	private FileService fileService;

	@GetMapping("/home")
	public String home(Model model, @RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "0") int page) {
		System.out.println("size " + size);
		System.out.println("page------------------------------------------------------------------------------------------------------- " + page);
		Page<Song> songs = songService.songsList(size, page);
		model.addAttribute("songs", songs.getContent());		
		model.addAttribute("totalPages", songs.getTotalPages() - 1);
		model.addAttribute("size", songs.getSize());
		model.addAttribute("number", songs.getNumber());
		
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact(Model model){
		model.addAttribute("contact", new contactDataTransferObject());
		return "contact";
	}
	
	@PostMapping("/contact")
	public String handleContact(RedirectAttributes redirect, contactDataTransferObject contact){
		
		//TODO: Send email user contact variable
		
		redirect.addFlashAttribute("message", "Your contact message has been sent, THANK!");
		
		return "redirect:/home";
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
		
		return "redirect:/home";
	}
	
	@GetMapping("/register")
	public String registrationForm(Model model) {
		model.addAttribute("user", new UserDataTransferObject());
		return "register";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/error")
	public String error(){
		return "error";
	}
}
