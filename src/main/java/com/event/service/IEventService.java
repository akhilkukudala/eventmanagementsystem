package com.event.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Event;

public interface IEventService {

	public Event addEvent(Event event);

	public Event eventById(@PathVariable("id") String id);

	public List<Event> getAllEvent();

	public List<Event> getByEveVenue(@PathVariable("evenue") String ebrand);

	public void delEvent(@PathVariable("id") String id);
}