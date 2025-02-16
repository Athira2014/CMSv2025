package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.User;

public interface IUserService {

	List<User> getAllUsers();

	User saveUser(User user);

}
