package com.event.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.model.User;
import com.event.service.ILoginService;

@RestController
public class LoginController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private ILoginService es;

	@GetMapping("login/{id}/{password}")
	public ResponseEntity<User> loginUser(@PathVariable("id") String id, @PathVariable("password") String pass,
			HttpServletRequest req) {
		logger.info("Information Checking through Login id and Password");

		User user = es.loginUser(id, pass, req);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

	}

	@PutMapping("additem/{id}/{pid}")
	public ResponseEntity<User> addProductForUser(@PathVariable("id") String uid, @PathVariable("pid") String pid,
			HttpServletRequest req) {
		logger.info("Information through UserId and Event Id");

		System.out.println(uid);
		System.out.println(pid);
		User u = es.userAddEvent(uid, pid, req);
		return new ResponseEntity<User>(u, HttpStatus.OK);

	}

}
