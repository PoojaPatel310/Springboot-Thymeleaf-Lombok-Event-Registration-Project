package com.aurosoft.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.event.entity.Event;
import com.aurosoft.event.entity.EventRegistration;
import com.aurosoft.event.service.EventRegistrationService;
import com.aurosoft.event.service.EventService;

@Controller
@RequestMapping("/eventregistration")
public class EventRegistrationController {
	@Autowired
	 private EventRegistrationService eventRegistrationService;
	@Autowired
	private EventService eventService;
	
	public EventRegistrationController(EventRegistrationService eventRegistrationService, EventService eventService) {
		super();
		this.eventRegistrationService = eventRegistrationService;
		this.eventService = eventService;
	}

	@GetMapping("/list")
	public String listAll(Model m) {
		List<EventRegistration> list= eventRegistrationService.listAllEventRegistrations();
		m.addAttribute("list",list);
		return "/eventRegistration/list";
	}
	
	@GetMapping("/new")
	public String showForm(EventRegistration eventRegistration,Model m) {
		List<Event> list= eventService.listAllEvents();
		m.addAttribute("listevent",list);
		return "/eventRegistration/add";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute("eventRegistration") EventRegistration eventRegistration) {
		eventRegistrationService.insertEventRegistration(eventRegistration);		
		return "redirect:/eventregistration/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		EventRegistration eventRegistration = eventRegistrationService.getEventRegistrationById(id);
		m.addAttribute("eventRegistration",eventRegistration);
		List<Event> list= eventService.listAllEvents();
		m.addAttribute("listevent",list);
		return "/eventRegistration/edit";
	}
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute("evntRegistration") EventRegistration eventRegistration ) {
		eventRegistrationService.updateEventRegistration(eventRegistration);		
		return "redirect:/eventregistration/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable int id) {
		eventRegistrationService.deleteEventRegistration(id);
		return "redirect:/eventregistration/list";
	}

}
