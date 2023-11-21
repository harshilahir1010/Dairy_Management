package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.EventSponser;

public interface EventSponserService {

	List<EventSponser> findAll();

	Optional<EventSponser> findSpecific(long id) throws Exception;

	EventSponser save(EventSponser eventSponser);

	EventSponser edit(long id, EventSponser eventSponser);

	String delete(long id);
	
	List<EventSponser> findVendorByEvent(long id);

}
