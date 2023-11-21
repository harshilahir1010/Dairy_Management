package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Optional<Customer> findSpecific(long id) throws Exception;

	Customer save(Customer customer);

	Customer edit(long id, Customer customer);

	String delete(long id);
	
	List<Customer> findCustomerByVendor(long id);

}
