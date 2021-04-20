package com.crud.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.login.entity.Group;
import com.crud.login.service.GroupService;
import com.crud.login.service.SecurityTokenGenerator;

@RestController
public class GroupController {
	
	@Autowired
	private GroupService service;
	

	@Autowired
	private SecurityTokenGenerator securityTokenGenerator;

	
	@PostMapping("/registeruser")
	@CrossOrigin
	public ResponseEntity<?> addGroup(@RequestBody Group group) {
//return service.saveGroup(group);
		try {
			service.saveGroup(group);
			return new ResponseEntity<>(HttpStatus.CREATED);			
		}catch (Exception e) {
			return new ResponseEntity<String>("{ \"message\":\""+e.getMessage(), HttpStatus.CONFLICT);
		}

}

	@PostMapping("/login")
	@CrossOrigin
	public ResponseEntity<?> getGroup(@RequestBody Group group) {
		String tempEmail=group.getEmailId();
		String tempPass=group.getPassword();
		Map<String, String> map = null;
		//return service.getGroupbyEmail(tempEmail);		
		Group userObj = service.findByEmailIdAndPassword(tempEmail,tempPass);
		if (userObj != null){
			map = securityTokenGenerator.generateToken(userObj);
			return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity<>( HttpStatus.OK);
		}	
		
}
	@PostMapping("/updateProfile")
	@CrossOrigin
	public Group updateGroup(@RequestBody Group group) {
		return service.updateGroup(group);
	}
}