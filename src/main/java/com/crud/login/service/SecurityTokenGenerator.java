package com.crud.login.service;


import java.util.Map;

import com.crud.login.entity.Group;


public interface SecurityTokenGenerator {
	
	Map<String, String> generateToken(Group group);

}
