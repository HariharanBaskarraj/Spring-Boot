package com.doctorapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doctorapp.model.AppUser;
import com.doctorapp.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private IUserRepository userRepository;
	@Autowired
	public void setuserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User name not found");
		GrantedAuthority authorityOne = new SimpleGrantedAuthority("ADMIN");
		GrantedAuthority authorityTwo = new SimpleGrantedAuthority("USER");
		List<GrantedAuthority> authorities = Arrays.asList(authorityOne, authorityTwo);

		String uname = user.getUsername();
		String password = user.getPassword();

		UserDetails userDetails = new User(uname, password, authorities);
		return userDetails;
	}

	
	public void addUser(AppUser user) {
		userRepository.save(user);
	}
}
