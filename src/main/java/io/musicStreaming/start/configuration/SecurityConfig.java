package io.musicStreaming.start.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.musicStreaming.start.filter.JwtFilter;
import io.musicStreaming.start.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
		authentication.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
			.antMatchers("/admin").hasRole(Role.admin)
			.antMatchers("/user").hasAnyRole(Role.admin, Role.user)
			.antMatchers("/").permitAll()
			.antMatchers("/error").permitAll();*/
		http.csrf().disable()
		.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().antMatchers("/authenticate").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/resources/**", "/js/**", "/favicon.ico", "/css/**", "/songs/**").permitAll()
		.anyRequest().authenticated().and()
		.exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();}
	
	//This code used for testing
	/*
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
     security.httpBasic().disable();
     security.cors().and().csrf().disable();
     
     security.headers().frameOptions().disable();
    }
    */
}
