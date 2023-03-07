package com.event.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.model.Event;

public interface EventDao extends JpaRepository<Event, String> {
	public List<Event> findByEvenue(String evenue);

}
