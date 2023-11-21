package com.demo.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dairy.dto.MessageDtoRequest;
import com.demo.dairy.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PostMapping("/send")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageDtoRequest request) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.sendMessage(request));
	}

}
