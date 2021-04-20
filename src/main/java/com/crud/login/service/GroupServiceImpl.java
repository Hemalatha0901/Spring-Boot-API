package com.crud.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.login.entity.Group;
import com.crud.login.repository.GroupRepository;

public class GroupServiceImpl {

	@Autowired
	GroupRepository repository;
	
	public Group findByEmailIdAndPassword(String username, String password)  {
		Group user = repository.findByEmailIdAndPassword(username, password);
		if (user == null) {
			return null;//throw new UserNotFoundException("username and password mismatch");
		} else {
			return user;

		}
	}
}
