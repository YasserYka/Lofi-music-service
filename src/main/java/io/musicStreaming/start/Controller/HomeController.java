package io.musicStreaming.start.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{

	@GetMapping
	public String home() {return "home";}
	
	@GetMapping("/user")
	@RequestMapping
	public String user() {
		return "Welcome user";
	}
	
	@GetMapping("/admin")
	@RequestMapping
	public String admin() {
		return "Welcome admin";
	}
}
