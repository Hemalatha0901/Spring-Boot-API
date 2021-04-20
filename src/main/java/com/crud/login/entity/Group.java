package com.crud.login.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Group_Members")
public class Group {

	@Id
	@GeneratedValue
	private int id;
	private String emailId;
	private String username;
	private String password;
	private String country;
	private String state;
	private String phone;
	private String address;
	

	/*private BookMembers bookAppointments;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="fk")
	public BookMembers getBookAppointments() {
		return bookAppointments;
	}
	public void setBookAppointments(BookMembers bookAppointments) {
		this.bookAppointments = bookAppointments;
	}
	*/
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Group() {
		
	}
	public Group(int id, String emailId, String username, String password, String address, String state, String country,String phone) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.address=address;
		this.state=state;
		this.country=country;
		this.phone=phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
