package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VenderBuses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String venderId;
	private String busID;
	private String busNoPlate;
	private String busDetails;
	private String rcNo;
	private String incurenceNo;
	private String rcPic;
	private String incurencePic;
	private String photo;
	private char isActive;
	private Date createAt;
	private Date updateAt;
	private String createdBy;
	private String updatedBy;
	private String isAc;
	public String getIsAc() {
		return isAc;
	}
	public void setIsAc(String isAc) {
		this.isAc = isAc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getBusID() {
		return busID;
	}
	public void setBusID(String busID) {
		this.busID = busID;
	}
	public String getBusNoPlate() {
		return busNoPlate;
	}
	public void setBusNoPlate(String busNoPlate) {
		this.busNoPlate = busNoPlate;
	}
	public String getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(String busDetails) {
		this.busDetails = busDetails;
	}
	public String getRcNo() {
		return rcNo;
	}
	public void setRcNo(String rcNo) {
		this.rcNo = rcNo;
	}
	public String getIncurenceNo() {
		return incurenceNo;
	}
	public void setIncurenceNo(String incurenceNo) {
		this.incurenceNo = incurenceNo;
	}
	public String getRcPic() {
		return rcPic;
	}
	public void setRcPic(String rcPic) {
		this.rcPic = rcPic;
	}
	public String getIncurencePic() {
		return incurencePic;
	}
	public void setIncurencePic(String incurencePic) {
		this.incurencePic = incurencePic;
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
	
	public VenderBuses() {
		super();
	}
	public VenderBuses(int id, String venderId, String busID, String busNoPlate, String busDetails, String rcNo,
			String incurenceNo, String rcPic, String incurencePic, String photo, char isActive, Date createAt,
			Date updateAt, String createdBy, String updatedBy, String isAc) {
		super();
		this.id = id;
		this.venderId = venderId;
		this.busID = busID;
		this.busNoPlate = busNoPlate;
		this.busDetails = busDetails;
		this.rcNo = rcNo;
		this.incurenceNo = incurenceNo;
		this.rcPic = rcPic;
		this.incurencePic = incurencePic;
		this.photo = photo;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.isAc = isAc;
	}
	@Override
	public String toString() {
		return "VenderBuses [id=" + id + ", venderId=" + venderId + ", busID=" + busID + ", busNoPlate=" + busNoPlate
				+ ", busDetails=" + busDetails + ", rcNo=" + rcNo + ", incurenceNo=" + incurenceNo + ", rcPic=" + rcPic
				+ ", incurencePic=" + incurencePic + ", photo=" + photo + ", isActive=" + isActive + ", createAt="
				+ createAt + ", updateAt=" + updateAt + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", isAc=" + isAc + "]";
	}
	
	

}
