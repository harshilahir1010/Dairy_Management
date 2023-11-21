package com.demo.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dairy.entity.Login;
import com.demo.dairy.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{loginId}")
	public ResponseEntity<?> findSpecific(@PathVariable long loginId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(loginId));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody @Valid  Login login){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(login));
	}
	
	@PutMapping("/edit/{loginId}")
	public ResponseEntity<?> edit(@RequestBody @Valid Login login,@PathVariable long loginId){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(loginId, login));
	}
	
	@DeleteMapping("delete/{loginId}")
	public ResponseEntity<?> delete(@PathVariable long loginId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(loginId));
	}

}
