package com.aurosoft.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.event.entity.EventRegistration;
import com.aurosoft.event.repository.EventRegistrationRepository;
import com.aurosoft.event.service.EventRegistrationService;

@Service
public class EventRegistrationServiceImpl implements EventRegistrationService {
	
	@Autowired
	EventRegistrationRepository repository;
	
	@Override
	public List<EventRegistration> listAllEventRegistrations() {
		
		return repository.findAll();
	}

	@Override
	public EventRegistration getEventRegistrationById(int id) {

		return repository.findById(id).orElseThrow();
	}

	@Override
	public EventRegistration insertEventRegistration(EventRegistration eventRegistration) {
		
		return repository.save(eventRegistration);
	}

	@Override
	public EventRegistration updateEventRegistration(EventRegistration eventRegistration) {
	
		return repository.save(eventRegistration);
	}

	@Override
	public int deleteEventRegistration(int id) {

		repository.deleteById(id);
		return id;
	}

	
}
