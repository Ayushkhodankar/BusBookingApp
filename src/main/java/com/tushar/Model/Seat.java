package com.tushar.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String seatNumber;
    private boolean booked;
    private String customerId;
    private String passengerName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerMob;
    private String passengerGender;
    private String passengerIdType;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerMob() {
		return passengerMob;
	}
	public void setPassengerMob(String passengerMob) {
		this.passengerMob = passengerMob;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getPassengerIdType() {
		return passengerIdType;
	}
	public void setPassengerIdType(String passengerIdType) {
		this.passengerIdType = passengerIdType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    
	

}
