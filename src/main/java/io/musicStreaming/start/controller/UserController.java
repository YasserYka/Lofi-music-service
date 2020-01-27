package io.musicStreaming.start.controller;

import io.musicStreaming.start.model.dto.UserDataTransferObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/profile")
	public void profile() {}
	
	@GetMapping("/register")
	public String registrationForm(WebRequest request, Model model) {
		model.addAttribute("userDto", new UserDataTransferObject());
		return "register";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
}
