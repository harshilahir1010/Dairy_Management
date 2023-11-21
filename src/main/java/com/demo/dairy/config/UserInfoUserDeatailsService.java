package com.demo.dairy.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.dairy.entity.Login;
import com.demo.dairy.repo.LoginRepo;
@Component
public class UserInfoUserDeatailsService implements UserDetailsService{
	
	@Autowired
	LoginRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> login=repo.findByUserName(username);
		return login.map(UserInfoUserDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("user not found "+username));
		
	}

}
