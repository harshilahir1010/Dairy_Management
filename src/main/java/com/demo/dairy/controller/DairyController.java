package com.demo.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dairy.entity.Dairy;
import com.demo.dairy.service.DairyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dairy")
public class DairyController {
	
	@Autowired
	private DairyService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{dairyId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> findSpecific(@PathVariable long dairyId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(dairyId));
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> save(@Valid @RequestBody Dairy dairy){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dairy));
	}
	
	@PutMapping("/edit/{dairyId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> edit(@Valid @PathVariable long dairyId,@RequestBody Dairy dairy){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(dairyId, dairy));
	}
	
	@DeleteMapping("/delete/{dairyId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> delete(@PathVariable long dairyId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(dairyId));
	}
	

}
