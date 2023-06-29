package com.tushar.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoundTrip {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pickup;
	private String destation;
	private String returnLocation;
	private String passangerNo;
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
	
	public String getReturnLocation() {
		return returnLocation;
	}
	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}
	public String getPassangerNo() {
		return passangerNo;
	}
	public void setPassangerNo(String passangerNo) {
		this.passangerNo = passangerNo;
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
	public String getDestation() {
		return destation;
	}
	public void setDestation(String destation) {
		this.destation = destation;
	}
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
}
