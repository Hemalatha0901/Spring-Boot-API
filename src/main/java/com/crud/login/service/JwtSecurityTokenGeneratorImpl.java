package com.crud.login.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.crud.login.entity.Group;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	@Override
	public Map<String, String> generateToken(Group group) {

		String jwtToken = "";

		jwtToken = Jwts.builder().setSubject(String.valueOf(group.getId())).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "microcredential").compact();

		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		return map;
	}

}
