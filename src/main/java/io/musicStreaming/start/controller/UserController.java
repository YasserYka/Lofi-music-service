package io.musicStreaming.start.controller;

import io.musicStreaming.start.configuration.UserDetail;
import io.musicStreaming.start.model.dto.AuthenticationRequest;
import io.musicStreaming.start.model.dto.AuthenticationResponse;
import io.musicStreaming.start.model.dto.ProfileDataTransferObject;
import io.musicStreaming.start.model.dto.UserDataTransferObject;
import io.musicStreaming.start.service.UserService;
import io.musicStreaming.start.utility.JWT;
import io.musicStreaming.start.validators.UserValidator;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWT jwtUtil;
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@PostMapping("/user")
	public String addUser(Model model,@Valid @ModelAttribute("user") UserDataTransferObject user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		userService.addUser(user);
		afterRegistering(user.getUsername(), user.getPassword());
		return "redirect:/login";
	}
	
	private void afterRegistering(String username, String password) {
		UserDetail userDetail = userService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetail, password, userDetail.getAuthorities());
        authenticationManager.authenticate(authToken);
        if(authToken.isAuthenticated())
        	SecurityContextHolder.getContext().setAuthentication(authToken);
	}

	@GetMapping("/user")
	@ResponseBody
	public ProfileDataTransferObject getUser(@RequestHeader (name="Authorization") String token){
		return new ProfileDataTransferObject().map(userService.loadUserByToken(token).get());
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request){
		try {authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));}
		catch(BadCredentialsException bad) {try {throw new Exception("Incorrect Username or Password", bad);} catch (Exception e) {}}
		final UserDetail userDetail = userService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetail);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
