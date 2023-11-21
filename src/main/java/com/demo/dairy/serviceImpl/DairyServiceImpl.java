package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.Dairy;
import com.demo.dairy.repo.DairyRepo;
import com.demo.dairy.service.DairyService;

@Service
public class DairyServiceImpl implements DairyService{
	
	@Autowired
	private DairyRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Dairy> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Dairy> findSpecific(long id)throws Exception {
		Optional<Dairy> dairy=repo.findById(id);
		if(dairy.isPresent()) {
			return dairy;
		}else {
			throw new Exception("Dairy Not Found by id "+id+" !!!!");
		}
		
	}

	@Override
	public Dairy save(Dairy dairy) {
		dairy.setDairyPassword(passwordEncoder.encode(dairy.getDairyPassword()));
		return repo.save(dairy);
	}

	@Override
	public Dairy edit(long id, Dairy dairy) {
		Dairy d=repo.findById(id).get();
		d.setDairyAddress(dairy.getDairyAddress());
		d.setDairyContact(dairy.getDairyContact());
		d.setDairyDescription(dairy.getDairyDescription());
		d.setDairyName(dairy.getDairyName());
		d.setDairyPassword(passwordEncoder.encode(dairy.getDairyPassword()));
		d.setDairyRatings(dairy.getDairyRatings());
		System.out.println(d);
		return repo.save(d);
	}

	@Override
	public String delete(long id) {
		Optional<Dairy> dairy=repo.findById(id);
		if(dairy.isPresent()) {
			Dairy d=repo.getOne(id);
			repo.delete(d);
			return "Dairy with "+id+" deleted sucessfully";
		}
		return "Dairy with "+id+" not present";
	}



	
	

}
