package com.crud.login.controller;


import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.login.entity.BookMembers;
import com.crud.login.repository.AppointmentRepository;
import com.crud.login.service.JWTTokenUtil;



@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class EmployeeController {
	@Autowired
	private AppointmentRepository appoint;
	
	@Autowired
	JWTTokenUtil tokenUtil;

	@GetMapping("/getbookinglist")
	public ResponseEntity<?> getAllEmployees(@RequestHeader Map<String,String> header ) {
		//return appoint.findAll();
		List<BookMembers> appt = appoint.findAllAppointmentsByUserId(tokenUtil.validateToken(header.get("token")));

		return new ResponseEntity<>(appt, HttpStatus.OK);
	}


	@PostMapping("/booking")
	public ResponseEntity<?> createEmployee( @RequestBody BookMembers book,@RequestHeader Map<String,String> header) {
		try {
			book.setUserId(((tokenUtil.validateToken(header.get("token")))));
			appoint.save(book);
			return new ResponseEntity<>(HttpStatus.CREATED);			
		}catch (Exception e) {
			return new ResponseEntity<String>("{ \"message\":\""+e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<BookMembers> updateEmployee(@PathVariable(value = "id") Integer bookId,
			 @RequestBody BookMembers bookDetails)  {
		BookMembers book = appoint.findById(bookId).orElse(null);
				
		book.setAge(bookDetails.getAge());
		book.setBlooGroup(bookDetails.getBlooGroup());
		book.setVenue(book.getVenue());
		book.setAppointmentDate(bookDetails.getAppointmentDate());
		book.setAppointEndDate(book.getAppointEndDate());
		book.setTime(bookDetails.getTime());
		//System.out.println("book veue..."+book.getVenue());
		final BookMembers updatedBooking = appoint.save(book);
		return ResponseEntity.ok(updatedBooking);
	}
	
	
	@GetMapping("/bookById/{id}")
	public ResponseEntity<BookMembers> getBookId(@PathVariable(value = "id") Integer bookId)
			 {
		BookMembers book = appoint.findById(bookId)
				.orElse(null);
		return ResponseEntity.ok().body(book);
	}
	
	@DeleteMapping("/deletebooking/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer bookId)
		 {
		Optional<BookMembers> deleteBook = appoint.findById(bookId);

		appoint.delete(deleteBook.get());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

