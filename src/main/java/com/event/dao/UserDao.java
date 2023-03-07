package com.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.model.User;

public interface UserDao extends JpaRepository<User, String> {

}