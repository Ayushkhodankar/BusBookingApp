package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String busName;
	private String busDetails;
	private String seater;
	private String type;
	private String perExtraDayChange;
	private String perKMPriceInCity;
	private String perKMPriceOutOfCity;
	private String photo;
	private char isActive;
	private Date createAt;
	private Date updateAt;
	private String createdBy;
	private String updatedBy;
	private String departureTime;
	private String destinationEndTime;
	private String totalTravelTime;
	private String noOfSeats;
	private String destinationStart;
	private String destinationEnd;
	private String busFare;
	private String date;

	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestinationEndTime() {
		return destinationEndTime;
	}
	public void setDestinationEndTime(String destinationEndTime) {
		this.destinationEndTime = destinationEndTime;
	}
	public String getTotalTravelTime() {
		return totalTravelTime;
	}
	public void setTotalTravelTime(String totalTravelTime) {
		this.totalTravelTime = totalTravelTime;
	}
	public String getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getDestinationStart() {
		return destinationStart;
	}
	public void setDestinationStart(String destinationStart) {
		this.destinationStart = destinationStart;
	}
	public String getDestinationEnd() {
		return destinationEnd;
	}
	public void setDestinationEnd(String destinationEnd) {
		this.destinationEnd = destinationEnd;
	}
	public String getBusFare() {
		return busFare;
	}
	public void setBusFare(String busFare) {
		this.busFare = busFare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(String busDetails) {
		this.busDetails = busDetails;
	}
	public String getSeater() {
		return seater;
	}
	public void setSeater(String seater) {
		this.seater = seater;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPerExtraDayChange() {
		return perExtraDayChange;
	}
	public void setPerExtraDayChange(String perExtraDayChange) {
		this.perExtraDayChange = perExtraDayChange;
	}
	public String getPerKMPriceInCity() {
		return perKMPriceInCity;
	}
	public void setPerKMPriceInCity(String perKMPriceInCity) {
		this.perKMPriceInCity = perKMPriceInCity;
	}
	public String getPerKMPriceOutOfCity() {
		return perKMPriceOutOfCity;
	}
	public void setPerKMPriceOutOfCity(String perKMPriceOutOfCity) {
		this.perKMPriceOutOfCity = perKMPriceOutOfCity;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public char getIsActive() {
		return isActive;
	}
	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Buses(int id, String busName, String busDetails, String seater, String type, String perExtraDayChange,
			String perKMPriceInCity, String perKMPriceOutOfCity, String photo, char isActive, Date createAt,
			Date updateAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.busName = busName;
		this.busDetails = busDetails;
		this.seater = seater;
		this.type = type;
		this.perExtraDayChange = perExtraDayChange;
		this.perKMPriceInCity = perKMPriceInCity;
		this.perKMPriceOutOfCity = perKMPriceOutOfCity;
		this.photo = photo;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public Buses() {
		super();
	}
	@Override
	public String toString() {
		return "Buses [id=" + id + ", busName=" + busName + ", busDetails=" + busDetails + ", seater=" + seater
				+ ", type=" + type + ", perExtraDayChange=" + perExtraDayChange + ", perKMPriceInCity="
				+ perKMPriceInCity + ", perKMPriceOutOfCity=" + perKMPriceOutOfCity + ", photo=" + photo + ", isActive="
				+ isActive + ", createAt=" + createAt + ", updateAt=" + updateAt + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
