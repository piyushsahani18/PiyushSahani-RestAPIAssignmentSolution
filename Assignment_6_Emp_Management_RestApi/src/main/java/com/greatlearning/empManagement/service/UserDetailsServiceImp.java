package com.greatlearning.empManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.empManagement.entities.User;
import com.greatlearning.empManagement.repository.UserRepository;
import com.greatlearning.empManagement.security.MyUserDetails;

public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("Username not valid!");
		
		return new MyUserDetails(user);
	}

}
