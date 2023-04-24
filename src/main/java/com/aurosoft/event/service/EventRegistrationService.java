package com.aurosoft.event.service;

import java.util.List;

import com.aurosoft.event.entity.EventRegistration;

public interface EventRegistrationService {
	
	List<EventRegistration> listAllEventRegistrations();
	EventRegistration getEventRegistrationById(int id);
	EventRegistration insertEventRegistration(EventRegistration eventRegistration);
	EventRegistration updateEventRegistration(EventRegistration eventRegistration);
	int deleteEventRegistration(int id);

}
