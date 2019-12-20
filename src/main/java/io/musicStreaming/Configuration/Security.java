package io.musicStreaming.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Security extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsersDetailsService usersDetailsService;
	
	/*@Override
	public void configure(AuthenticationManagerBuilder authentication) {
		authentication.userDetailsService(usersDetailsService);
	}*/
}
