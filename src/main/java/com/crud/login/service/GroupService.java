package com.crud.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.login.entity.Group;
import com.crud.login.repository.GroupRepository;

@Service
public class GroupService {
@Autowired
	private GroupRepository repository;

public Group saveGroup(Group group) {
	return repository.save(group);
}


public Group getGroupbyEmail(String email) {
	return repository.findByEmailId(email);
}
	
public Group findByEmailIdAndPassword(String email, String password) {
	return repository.findByEmailIdAndPassword(email, password);
}

/*public String deleteGroup(int id)
{
repository.deleteById(id);	
return "Member removed"+id;
}*/
public Group updateGroup(Group group)
{
	Group existingProfile = repository.findByEmailId(group.getEmailId()); 
	existingProfile.setPassword(group.getPassword());
	existingProfile.setPhone(group.getPhone());
	existingProfile.setAddress(group.getAddress());
	existingProfile.setState(group.getState());
	existingProfile.setUsername(group.getUsername());
	existingProfile.setCountry(group.getCountry());
	return repository.save(existingProfile);
}
}
