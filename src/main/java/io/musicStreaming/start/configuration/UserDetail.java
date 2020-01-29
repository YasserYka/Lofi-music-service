package io.musicStreaming.start.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.musicStreaming.start.model.User;

public class UserDetail implements UserDetails{

	private String username;
	private String name;
	private String plan;
	private String imageUrl;
	private String email;
	private String password;
	private String phoneNumber;
	private String signupDate;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	public UserDetail() {}
	
	public UserDetail(User user) {
		this.username = user.getUsername();
		this.name = user.getName();
		this.plan = user.getPlan();
		this.imageUrl = user.getImageUrl();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phoneNumber = user.getPhoneNumber();
		this.signupDate = user.getSignupDate();
		this.enabled = user.isEnabled();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
