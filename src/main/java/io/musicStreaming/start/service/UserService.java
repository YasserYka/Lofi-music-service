package io.musicStreaming.start.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.musicStreaming.start.configuration.UserDetail;
import io.musicStreaming.start.model.User;
import io.musicStreaming.start.model.dto.UserDataTransferObject;
import io.musicStreaming.start.repository.UserRepository;
import io.musicStreaming.start.utility.JWT;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JWT jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user =  repository.findById(username);
		user.orElseThrow(()->new UsernameNotFoundException("Coulding find User"));
		return user.map(UserDetail::new).get();
	}

	public Optional<User> loadUserByToken(String token){
		return repository.findById(jwtUtil.extractUsername(token));
	}

	public void addUser(UserDataTransferObject userDto) {
		User user = new User();
		
		user.setEmail(userDto.getEmail());
		
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		user.setName(userDto.getFirstName());
		
		user.setUsername(userDto.getUsername());
		
		user.setRoles("ROLE_USER");
		
		user.setEnabled(true);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(userDto.getUsername());
		System.out.println(passwordEncoder.encode(userDto.getPassword()));
		System.out.println(repository.count());
		repository.save(user);
	}
	
	public boolean isUsernameExits(String username) {
		return repository.existsById(username);
	}
	
	public boolean isEmailExits(String email) {
		return repository.existsByEmail(email);
	}
}
