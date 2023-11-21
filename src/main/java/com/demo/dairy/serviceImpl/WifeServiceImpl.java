package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.Wife;
import com.demo.dairy.repo.WifeRepo;
import com.demo.dairy.service.WifeService;

@Service
public class WifeServiceImpl implements WifeService{
	
	@Autowired
	private WifeRepo repo;

	@Override
	public List<Wife> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Wife> findSpecific(long id) throws Exception {
		Optional<Wife> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional;
		}else {
			throw new Exception("Wife is not present for id "+id);
		}
		
	}

	@Override
	public Wife save(Wife wife) {
		// TODO Auto-generated method stub
		return repo.save(wife);
	}

	@Override
	public Wife edit(long id, Wife wife) {
		Wife w=repo.findById(id).get();
		w.setVendor(wife.getVendor());
		w.setWifeDish(wife.getWifeDish());
		w.setWifeDishPrice(w.getWifeDishPrice());
		w.setWifeName(wife.getWifeName());
		return repo.save(w);
	}

	@Override
	public String delete(long id) {
		Optional<Wife> optional=repo.findById(id);
		if(optional.isPresent()) {
			Wife wife=repo.findById(id).get();
			repo.delete(wife);
			return "Data of wife for id "+id+" is sucesfully deleted";
		}else {
			return "Data for wife on id "+id+" is not presented";
		}
		
	}

}
