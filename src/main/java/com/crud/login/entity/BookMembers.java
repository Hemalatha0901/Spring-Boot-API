package com.crud.login.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Book_Members")
public class BookMembers {
	@Id
	@GeneratedValue
	private int id;
	public String blooGroup;
	public String age;
	public String appointmentDate;
	public String venue;
	public String time;
	public String appointEndDate;


		public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	private Integer userId;
	
	/*@OneToOne(targetEntity = BookMembers.class, cascade = CascadeType.ALL)
	@JoinColumn(name="boo_fk", referencedColumnName="id")
	private List<BookMembers> bookAppointments;
	*/
	public String getAppointEndDate() {
		return appointEndDate;
	}
	public void setAppointEndDate(String appointEndDate) {
		this.appointEndDate = appointEndDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlooGroup() {
		return blooGroup;
	}
	public void setBlooGroup(String blooGroup) {
		this.blooGroup = blooGroup;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
public BookMembers() {
		
	}
	public BookMembers(int id, String blooGroup, String age, String appointmentDate, String venue, String time, String appointEndDate, Integer userId) {
		super();
		this.id = id;
		this.blooGroup = blooGroup;
		this.age = age;
		this.appointmentDate = appointmentDate;
		this.venue = venue;
		this.time=time;
		this.appointEndDate = appointEndDate;
		this.userId=userId;
	}
	
	
}
