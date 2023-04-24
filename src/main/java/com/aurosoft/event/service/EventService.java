package com.aurosoft.event.service;

import java.util.List;

import com.aurosoft.event.entity.Event;

public interface EventService {
	
	List<Event> listAllEvents();
	Event getEventById(int id);
	Event insertEvent(Event event);
	Event updateEvent(Event event);	
	int deleteEvent(int id);

}
