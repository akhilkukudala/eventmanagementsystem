package com.event.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.User;

public interface ILoginService {
	public User loginUser(@PathVariable("id") String id, @PathVariable("password") String pass, HttpServletRequest req);

	

	public User userAddEvent(@PathVariable("id")String uid, @PathVariable("pid")String pid, HttpServletRequest req);

}