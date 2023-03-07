package com.event.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.User;

public interface IUserService {
	public User createAccount(User user);

	public List<User> getAllUser();

	public User loginById(@PathVariable("id") String id);

}