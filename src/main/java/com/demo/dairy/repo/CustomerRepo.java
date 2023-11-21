package com.demo.dairy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	List<Customer> findByVendorVendorId(long id);

}
