package io.musicStreaming.start.controller;

import io.musicStreaming.start.configuration.UserDetail;
import io.musicStreaming.start.model.dto.AuthenticationRequest;
import io.musicStreaming.start.model.dto.AuthenticationResponse;
import io.musicStreaming.start.model.dto.UserDataTransferObject;
import io.musicStreaming.start.model.dto.contactDataTransferObject;
import io.musicStreaming.start.service.UserService;
import io.musicStreaming.start.utility.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWT jwtUtil;
	
	@GetMapping("/profile")
	public void profile() {}
	
	@PostMapping("/users")
	@ResponseBody
	public void addUser(UserDataTransferObject user) {
		userService.addUser(user);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
		try {authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));}
		catch(BadCredentialsException bad) {throw new Exception("Incorrect Username or Password", bad);}
		final UserDetail userDetail = userService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetail);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
