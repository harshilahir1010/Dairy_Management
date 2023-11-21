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

import com.demo.dairy.entity.Customer;
import com.demo.dairy.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	
	@GetMapping("/vendor/{vendorId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY','ROLE_VENDOR')")
	public ResponseEntity<?> findCustomerAsVendor(@PathVariable long vendorId){
		return ResponseEntity.status(HttpStatus.OK).body(service.findCustomerByVendor(vendorId));
	}
	
	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY','ROLE_VENDOR')")
	public ResponseEntity<?> findAll(){
		System.out.println("enter");
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{customerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_DAIRY','ROLE_VENDOR')")
	public ResponseEntity<?> findSpecific(@PathVariable long customerId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(customerId));
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> save(@Valid @RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customer));
	}
	
	@PutMapping("/edit/{customerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> edit(@Valid @RequestBody Customer customer,@PathVariable long customerId){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(customerId, customer));
	}
	
	@DeleteMapping("delete/{customerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_VENDOR')")
	public ResponseEntity<?> delete(@PathVariable long customerId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(customerId));
	}

}
