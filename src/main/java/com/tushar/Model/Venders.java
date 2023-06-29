package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Venders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@NotNull(message = "Mobile No can't be null")
	private String mob;
	private String password;
	private String email;
	private String adrs;
	private String pincode;
	private String panCard;
	private String gstNo;
	private String logo;
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
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
	public Venders(int id, String name, @NotNull(message = "Mobile No can't be null") String mob, String password,
			String email, String adrs, String pincode, String panCard, String gstNo, String logo, char isActive,
			Date createAt, Date updateAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.mob = mob;
		this.password = password;
		this.email = email;
		this.adrs = adrs;
		this.pincode = pincode;
		this.panCard = panCard;
		this.gstNo = gstNo;
		this.logo = logo;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public Venders() {
		super();
	}
	@Override
	public String toString() {
		return "Venders [id=" + id + ", name=" + name + ", mob=" + mob + ", password=" + password + ", email=" + email
				+ ", adrs=" + adrs + ", pincode=" + pincode + ", panCard=" + panCard + ", gstNo=" + gstNo + ", logo="
				+ logo + ", isActive=" + isActive + ", createAt=" + createAt + ", updateAt=" + updateAt + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
	

}
