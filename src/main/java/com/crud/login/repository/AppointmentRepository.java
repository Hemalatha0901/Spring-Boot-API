package com.crud.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.login.entity.BookMembers;

public interface AppointmentRepository extends JpaRepository<BookMembers, Integer> {


	//List<BookMembers> getAppointmentByUserId(Integer userId);

	List<BookMembers> findAllAppointmentsByUserId(Integer userId);
	
}
