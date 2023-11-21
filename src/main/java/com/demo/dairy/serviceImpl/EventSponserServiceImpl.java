package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.EventSponser;
import com.demo.dairy.repo.EventSponserRepo;
import com.demo.dairy.service.EventSponserService;

@Service
public class EventSponserServiceImpl implements EventSponserService{
	
	@Autowired
	private EventSponserRepo repo;

	@Override
	public List<EventSponser> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<EventSponser> findSpecific(long id) throws Exception {
		Optional<EventSponser> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional;
		}else {
			throw new Exception("Please enter a valid id "+id+" is not present");
      		}
	}

	@Override
	public EventSponser save(EventSponser eventSponser) {
		// TODO Auto-generated method stub
		return repo.save(eventSponser);
	}

	@Override
	public EventSponser edit(long id, EventSponser eventSponser) {
		EventSponser e=repo.findById(id).get();
		e.setSponserEventBudget(eventSponser.getSponserEventBudget());
		e.setSponserEventDetails(eventSponser.getSponserEventDetails());
		e.setSponserEventName(eventSponser.getSponserEventName());
		e.setVendor(eventSponser.getVendor());
		return repo.save(e);
	}

	@Override
	public String delete(long id) {
		Optional<EventSponser> optional=repo.findById(id);
		if(optional.isPresent()) {
			EventSponser eventSponser=repo.findById(id).get();
			repo.delete(eventSponser);
			return "Event sucessfully deleted for id "+id;
		}else {
			return "No event is present on id "+id;
		}
		
	}

	@Override
	public List<EventSponser> findVendorByEvent(long id) {
		// TODO Auto-generated method stub
		return repo.findByVendorVendorId(id);
	}

}
