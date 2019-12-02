package io.musicStreaming.start.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	//this endpoint should appear after logging in only
	@GetMapping("/info")
	public void userinfo() {}
}
