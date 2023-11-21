package com.demo.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dairy.service.ParlourLoanService;

@RestController
@RequestMapping("/parlour/loan")
public class ParlourLoanController {
	
	@Autowired
	private ParlourLoanService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR','ROLE_DAIRY')")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{vendorId}/approve")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR','ROLE_DAIRY')")
	public ResponseEntity<?> approvedStatus(@PathVariable long vendorId){
		return ResponseEntity.status(HttpStatus.OK).body(service.getApproved(vendorId));
	}

}
