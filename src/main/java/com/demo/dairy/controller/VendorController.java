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

import com.demo.dairy.entity.Vendor;
import com.demo.dairy.service.VendorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService service;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY','ROLE_VENDOR')")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{vendorId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY','ROLE_VENDOR')")
	public ResponseEntity<?> findSpecific(@PathVariable long vendorId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(vendorId));
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> save(@Valid @RequestBody Vendor vendor){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(vendor));
	}
	
	@PutMapping("/edit/{vendorId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> edit(@Valid @RequestBody Vendor vendor,@PathVariable long vendorId){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(vendorId, vendor));
	}
	
	@DeleteMapping("delete/{vendorId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY')")
	public ResponseEntity<?> delete(@PathVariable long vendorId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(vendorId));
	}

}
