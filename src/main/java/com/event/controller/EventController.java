package com.event.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.event.model.Event;
import com.event.service.EventServiceImpl;

@RestController
public class EventController {
	@Autowired
	private EventServiceImpl es;
	Logger logger = org.slf4j.LoggerFactory.getLogger(EventController.class);

	@PostMapping("addEvent")
	public ResponseEntity<Event> addEve(@RequestBody Event event) {
		logger.info("Add Event Information Checking");
		Event eve = es.addEvent(event);
		return new ResponseEntity<Event>(eve, HttpStatus.CREATED);
	}

	@GetMapping("byId/{id}")
	public ResponseEntity<Event> eventById(@PathVariable("id") String id) {
		logger.info("Information Checking through Id");
		Event eve = es.eventById(id);
		return new ResponseEntity<Event>(eve, HttpStatus.FOUND);
	}

	@GetMapping("getAll")
	public ResponseEntity<List<Event>> getAllEvent() {
		logger.info("Information Checking for all Event");
		List<Event> list = es.getAllEvent();
		return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
	}

	@DeleteMapping("delEvent/{id}")
	public ResponseEntity<Event> delEvent(@PathVariable("id") String id) {
		logger.info("Delete Event Information Checking");
		es.delEvent(id);
		System.out.println("deleted");
		return new ResponseEntity<Event>(HttpStatus.ACCEPTED);
	}

	@GetMapping("byVenue/{evenue}")
	public ResponseEntity<List<Event>> getByVenue(@PathVariable("evenue") String venue) {
		logger.info("Information Checking for  all Event by brand");
		List<Event> events = es.getByEveVenue(venue);
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

}