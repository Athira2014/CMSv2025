package com.athira.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IUserDao;
import com.athira.demo.entity.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDao userDao;

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

}
