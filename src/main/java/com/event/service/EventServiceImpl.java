package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.dao.EventDao;
import com.event.exception.EmptyInputException;
import com.event.model.Event;

@Service
public class EventServiceImpl implements IEventService {
	@Autowired
	private EventDao ed;

	@Override
	public Event addEvent(Event event) {
		if (event.getEname().isEmpty() || event.getEname().length() == 0) {
			throw new EmptyInputException("601", "Input Fields can't be empty");
		} else if (event.getEvenue().isEmpty() || event.getEvenue().length() == 0) {
			throw new EmptyInputException("601", "Input Fields can't be empty");
		} else if (event.getEorganizer().isEmpty() || event.getEorganizer().length() == 0) {
			throw new EmptyInputException("601", "Input Fields can't be empty");
		} else if (event.getPrice() == 0) {
			throw new EmptyInputException("601", "Input Fields can't be empty");
		}
		return ed.save(event);
	}

	@Override
	public Event eventById(String id) {
		// TODO Auto-generated method stub
		return ed.findById(id).get();
	}

	@Override
     public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		return ed.findAll();
	}

	@Override
	public List<Event> getByEveVenue(String evenue) {
		// TODO Auto-generated method stub
		return ed.findByEvenue(evenue);
	}

	@Override
	public void delEvent(String id) {

		ed.deleteById(id);
	}

	

}
