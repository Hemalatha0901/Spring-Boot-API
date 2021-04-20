package com.crud.login.service;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTTokenUtil {
	
	private static final long serialVersionUID = -2550185165626007488L;

	private String getUserIdfromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	final Claims claims = getAllClaimsFromToken(token);
	return claimsResolver.apply(claims);
	}
	    //for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey("microcredential").parseClaimsJws(token).getBody();
	}

	//validate token
	public Integer validateToken(String token) {
		final String userId = getUserIdfromToken(token);
		return Integer.valueOf(userId);
	}
	
	

}
