package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String gender;
	private String dob;
	private String adrs;
	private String pincode;
	private String email;
	@NotNull(message = "Mobile No can't be null")
	private String mob;
	private String photo;
	private String password;
	
	private char isActive;
	private Date createAt;
	private Date updateAt;
	private String createdBy;
	private String updatedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Customers(int id, String name, String gender, String dob, String adrs, String pincode, String email,
			@NotNull(message = "Mobile No can't be null") String mob, String photo, String password, char isActive,
			Date createAt, Date updateAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.adrs = adrs;
		this.pincode = pincode;
		this.email = email;
		this.mob = mob;
		this.photo = photo;
		this.password = password;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public Customers() {
		super();
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", adrs=" + adrs
				+ ", pincode=" + pincode + ", email=" + email + ", mob=" + mob + ", photo=" + photo + ", password="
				+ password + ", isActive=" + isActive + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
	
	

}
