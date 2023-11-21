package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.Customer;
import com.demo.dairy.repo.CustomerRepo;
import com.demo.dairy.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Customer> findSpecific(long id) throws Exception {
		Optional<Customer> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional;
		}else {
			throw new Exception("Customer is not present in id"+id);
		}
		
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	@Override
	public Customer edit(long id, Customer customer) {
		Customer c=repo.findById(id).get();
		c.setCustomerFeedback(customer.getCustomerFeedback());
		c.setCustomerContact(customer.getCustomerContact());
		c.setCustomerName(customer.getCustomerName());
		c.setCustomerRatings(customer.getCustomerRatings());
		c.setVendor(customer.getVendor());
		return repo.save(c);
	}

	@Override
	public String delete(long id) {
		Optional<Customer> optional=repo.findById(id);
		if(optional.isPresent()) {
			Customer customer=repo.findById(id).get();
			repo.delete(customer);
			return "Customer deleted sucessfully";
		}else {
			return "Please enter valid customer id";
		}
		
	}

	@Override
	public List<Customer> findCustomerByVendor(long id) {
		
		return repo.findByVendorVendorId(id);
	}
	
}
