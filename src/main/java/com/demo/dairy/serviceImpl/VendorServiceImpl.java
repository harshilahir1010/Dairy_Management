package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.Vendor;
import com.demo.dairy.repo.VendorRepo;
import com.demo.dairy.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Vendor> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Vendor> findSpecific(long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Vendor> vendor=repo.findById(id);
		if(vendor.isPresent()) {
			return vendor;
		}else {
			throw new Exception("Vendor is not present for id "+id);
		}
	}

	@Override
	public Vendor save(Vendor vendor) {
		vendor.setVendorPassword(passwordEncoder.encode(vendor.getVendorPassword()));
		return repo.save(vendor);
	}

	@Override
	public Vendor edit(long id, Vendor vendor) {
		Vendor v=repo.findById(id).get();
		v.setVendorChargeLocation(vendor.getVendorChargeLocation());
		v.setVendorContact(vendor.getVendorContact());
		v.setVendorExperience(vendor.getVendorExperience());
		v.setVendorLocation(vendor.getVendorLocation());
		v.setVendorName(vendor.getVendorName());
		v.setVendorPassword(passwordEncoder.encode(vendor.getVendorPassword()));
		return repo.save(v);
	}

	@Override
	public String delete(long id) {
		Optional<Vendor> optional=repo.findById(id);
		if(optional.isPresent()) {
			Vendor v=repo.findById(id).get();
			repo.delete(v);
			return "Vendor of id "+id+" deleted sucessfully";
		}else {
			return "Please give correct id ";
		}
		
	}

}
