package com.demo.dairy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Long>{

}
