package com.event.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.exception.PasswordIncorrectException;
import com.event.model.User;
import com.event.service.IUserService;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	private IUserService us;
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@PostMapping("createaccount")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		logger.info("Information Checking for creating account");
		if (user.getPassword().equals(user.getPasswordConfirm())) {
			User savedUser = us.createAccount(user);
			System.out.println("Account Created");
			System.out.println(savedUser);
			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

		} else {
			throw new PasswordIncorrectException("601",
					"Password does not match with confirm password\nPlease enter the same password in both the fields");
		}

	}

	@GetMapping("getalluser")
	public ResponseEntity<List<User>> getAllUser() {
		logger.info("checking information for getting the User");
		List<User> list = us.getAllUser();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@GetMapping("specificuser/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") String id) // ask
	{
		logger.info("Information through Userid");
		User u = us.loginById(id);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
}
