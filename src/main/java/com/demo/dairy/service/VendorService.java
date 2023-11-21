package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.Vendor;

public interface VendorService {
	
    List<Vendor> findAll();
	
	Optional<Vendor> findSpecific(long id) throws Exception;
	
	Vendor save(Vendor vendor);
	
	Vendor edit(long id,Vendor vendor);
	
	String delete(long id);

}
