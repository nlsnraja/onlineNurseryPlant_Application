package com.sprint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sprint.entities.Role;

/**
 * Indicates that this is a "Security Configuration class", developed for the
 * sprint project "Online Plant Nursery Application" This class is developed for
 * securing the website from attackers and also to provide Authentication and
 * Authorization for the users according to their role.
 * 
 * @Date 26.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// AUTOWIRED WITH USER DETAILS SERVICE
	@Autowired
	UserDetailsService userDetailsService;

	// CONFIGURING AUTHENTICATION MANAGER BUILDER
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	// CONFIGURING HTTP SECURITY
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole(Role.ADMIN)
				.antMatchers(HttpMethod.POST).hasRole(Role.ADMIN)
				.antMatchers("/customer/**", "/order/**", "/planters/**", "/plant/**", "/seed/**")
				.hasAnyRole(Role.ADMIN, Role.USER).and().authorizeRequests().anyRequest().permitAll().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic();

	}

	// BCRYPT PASSWORD ENCODER
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}