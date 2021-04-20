 /*package com.crud.login.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.login.entity.BookMembers;
import com.crud.login.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository bookRepo;
	
	 private BookMembers appointmentEdit;
	
	
	 public ArrayList<BookMembers> fetchAppointmentFromRepo(){
	        return (ArrayList<BookMembers>) bookRepo.findAll();
	    }
	 public BookMembers persistProductIntoRepository(BookMembers book){
	       return bookRepo.save(book);
	    }
	 
	 public Optional<BookMembers> fetchBookFromRepositoryById(int id)
	    {
	        return bookRepo.findById(id);
	    }
	    
	 public String updateProductInRepository(BookMembers book) {
	        
	        	Booking appointmentEdit = bookRepo.findById(book.getId());

	        	appointmentEdit.setAge(book.getAge());
	        	appointmentEdit.setAppointmentDate(book.getAppointmentDate());
	        	appointmentEdit.setVenue(book.getVenue());
	        	appointmentEdit.setBlooGroup(book.getBlooGroup());
	            bookRepo.save(appointmentEdit);
	            
	            return "Booking Updated";
	 
	    }
	  /* public String deleteProductById(int id) {
	        try
	        {
	            bookRepo.deleteById(id);
	            return "Booking Deleted Successfully";
	        }catch (Exception e){
	            return "Booking not found";
	        }

	    }
}
*/