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

import com.demo.dairy.entity.Wife;
import com.demo.dairy.service.WifeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/wife")
public class WifeController {
	
	@Autowired
	private WifeService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{wifeId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findSpecific(@PathVariable long wifeId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(wifeId));
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> save(@Valid @RequestBody Wife wife){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(wife));
	}
	
	@PutMapping("/edit/{wifeId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> edit(@Valid @RequestBody Wife wife,@PathVariable long wifeId){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(wifeId, wife));
	}
	
	@DeleteMapping("delete/{wifeId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> delete(@PathVariable long wifeId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(wifeId));
	}

}
