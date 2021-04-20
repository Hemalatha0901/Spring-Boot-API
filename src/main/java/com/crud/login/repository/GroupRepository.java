package com.crud.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.login.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer>{

	Group findByEmailIdAndPassword(String emailId, String password);
	Group findByEmailId(String emailId);
}
