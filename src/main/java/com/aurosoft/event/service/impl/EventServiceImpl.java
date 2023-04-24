package com.aurosoft.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.event.entity.Event;
import com.aurosoft.event.repository.EventRepository;
import com.aurosoft.event.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	EventRepository repository;
	
	@Override
	public List<Event> listAllEvents() {
		
		return repository.findAll() ;
	}

	@Override
	public Event getEventById(int id) {
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Event insertEvent(Event event) {
		
		return repository.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
	
		return repository.save(event);
	}

	@Override
	public int deleteEvent(int id) {

		repository.deleteById(id);
		return id;
	}

	
	
}
