/*package com.crud.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.login.service.AppointmentService;
import com.crud.login.entity.BookMembers;
import java.util.ArrayList;

public class AppointmentController {

    @Autowired
    private AppointmentService service;

    ArrayList<BookMembers> bookings;

    
    @GetMapping("/getbookinglist")
    @CrossOrigin
	  public ArrayList<BookMembers> fetchBookList(){
        //Logic to fetch list from database
    	bookings = new ArrayList<BookMembers>();
    	bookings = service.fetchAppointmentFromRepo();
         return bookings;
    }
    
    @PostMapping("/addbooking")
    @CrossOrigin
    public BookMembers saveProduct(@RequestBody BookMembers book){
        //Logic to save the product into database
       return service.persistProductIntoRepository(book);
    }
	

    @DeleteMapping("/booking/{id}")
    @CrossOrigin
    public String deleteBooking(@RequestBody int id){
        //Logic to get delete product by id from database
        return service.deleteProductById(id);
    }
    
}
*/