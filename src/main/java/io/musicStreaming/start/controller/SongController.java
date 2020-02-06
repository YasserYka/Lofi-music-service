package io.musicStreaming.start.controller;

import io.musicStreaming.start.configuration.UserDetail;
import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.service.FileService;
import io.musicStreaming.start.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


	@GetMapping("/song/{id}")
	public String getSong(Model model, @PathVariable Long id) {
		model.addAttribute("song", songService.findById(id));
		return "play";
	}
}