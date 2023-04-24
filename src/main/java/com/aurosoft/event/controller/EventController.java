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
import com.aurosoft.event.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	
	@GetMapping("/list")
	public String listAll(Model m) {
		List<Event>list= eventService.listAllEvents();
		m.addAttribute("list",list);
		return "/event/list";
	}
	
	@GetMapping("/new")
	public String showForm(Event event) {
		return "/event/add";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ("event") Event event) {
		eventService.insertEvent(event);
		return "redirect:/event/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Event event =eventService.getEventById(id);
		m.addAttribute("event", event);
		return "/event/edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ("event") Event event) {
		eventService.updateEvent(event);
		return "redirect:/event/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		eventService.deleteEvent(id);
		return "redirect:/event/list";
	}
	
}
