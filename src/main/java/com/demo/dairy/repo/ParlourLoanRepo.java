package com.demo.dairy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.ParlourLoan;

public interface ParlourLoanRepo extends JpaRepository<ParlourLoan, Long>{
	
	ParlourLoan findByVendorId(long vendorId);

}
