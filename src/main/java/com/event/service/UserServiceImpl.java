package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.dao.UserDao;
import com.event.model.User;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao ud;

	@Override
	public User createAccount(User user) {
		// TODO Auto-generated method stub
		return ud.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return ud.findAll();
	}

	@Override
	public User loginById(String id) {
		// TODO Auto-generated method stub
		return ud.findById(id).get();
	}
	//public void addNewUser(User user) {
		//ud.save(user);
	//}
}