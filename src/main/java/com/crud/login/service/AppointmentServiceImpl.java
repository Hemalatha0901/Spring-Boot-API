package com.crud.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.crud.login.entity.BookMembers;
import com.crud.login.repository.AppointmentRepository;

@Component
public abstract  class AppointmentServiceImpl implements AppointmentRepository{

	@Autowired
	AppointmentRepository repository;
	
	public List<BookMembers> getAppointmentByUserId(Integer userId) {
		System.out.println("User Id"+ userId);
		return repository.findAllAppointmentsByUserId(userId);

	}

	
}
