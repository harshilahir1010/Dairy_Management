package com.demo.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dairy.dto.DtoRequest;
import com.demo.dairy.service.JwtService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody DtoRequest dtoRequest) {
	    Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoRequest.getUserName(), dtoRequest.getPassword()));
	    if(authentication.isAuthenticated()) {
	    	return jwtService.generateToken(dtoRequest.getUserName());
	    }else
	    {
	    	throw new UsernameNotFoundException("invalid user request");
	    }
		
		
	}

}
