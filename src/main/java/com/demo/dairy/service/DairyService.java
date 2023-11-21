package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.Dairy;

public interface DairyService {
	
	List<Dairy> findAll();
	
	Optional<Dairy> findSpecific(long id) throws Exception;
	
	Dairy save(Dairy dairy);
	
	Dairy edit(long id,Dairy dairy);
	
	String delete(long id);

}
