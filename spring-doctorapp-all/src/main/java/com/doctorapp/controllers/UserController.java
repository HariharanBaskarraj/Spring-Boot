package com.doctorapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.AppUser;
import com.doctorapp.service.UserDetailsServiceImpl;

@RestController
public class UserController {
		
	private PasswordEncoder encoder;
	@Autowired
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@PostMapping("/users")
	public String addUser(@RequestBody AppUser user) {
		String password = user.getPassword();
		String newPassword = encoder.encode(password);
		user.setPassword(newPassword);
		userDetailsService.addUser(user);
		return "Added";
	}
}
