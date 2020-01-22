package io.musicStreaming.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{

	@GetMapping("/")
	public String landingPage() {return "home";}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "Welcome user";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Welcome admin";
	}
	
	
}
