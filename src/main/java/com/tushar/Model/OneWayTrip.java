package com.tushar.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OneWayTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String pickup;
	private String destination;
	private String noofPassanger;
	private String fromDate;
	private String toDate;
	private String varient;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getNoofPassanger() {
		return noofPassanger;
	}
	public void setNoofPassanger(String noofPassanger) {
		this.noofPassanger = noofPassanger;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
	
	
}
