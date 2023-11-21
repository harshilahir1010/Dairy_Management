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

import com.demo.dairy.entity.EventSponser;
import com.demo.dairy.service.EventSponserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventsponser")
public class EventSponserController {
	
	@Autowired
	private EventSponserService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findAll(){
		System.out.println("hii");
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{eventSponserId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findSpecific(@PathVariable long eventSponserId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(eventSponserId));
	}
	
	@GetMapping("/vendor/organise/{vendorId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> findVendorByEvent(@PathVariable long vendorId){
		return ResponseEntity.status(HttpStatus.OK).body(service.findVendorByEvent(vendorId));
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> save(@Valid @RequestBody EventSponser eventSponser){
		System.out.println("hello");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(eventSponser));
	}
	
	@PutMapping("/edit/{eventSponserId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> edit(@Valid @RequestBody EventSponser eventSponser,@PathVariable long eventSponserId){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(eventSponserId, eventSponser));
	}
	
	@DeleteMapping("delete/{eventSponserId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> delete(@PathVariable long eventSponserId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(eventSponserId));
	}

}
