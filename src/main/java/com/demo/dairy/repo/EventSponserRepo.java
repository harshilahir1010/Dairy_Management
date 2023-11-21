package com.demo.dairy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.EventSponser;

public interface EventSponserRepo extends JpaRepository<EventSponser, Long>{
	
	List<EventSponser> findByVendorVendorId(long id);

}
