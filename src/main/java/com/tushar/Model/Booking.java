package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tushar.enumClasses.IsActive;
import com.tushar.enumClasses.BookingStatuses;
import com.tushar.enumClasses.YesNoPending;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String customerId;
	private String customerName;
	private String customerMob;
	private String noOfPassenger;
	private String description;
	private String busId;
	private String seater;
	private String type;
	private String isAc;
	private String typeOfTrip;
	private String destinations;
	
	private String venderId;
	private String venderBusId;
	private String driverName;
	private String driverMob;
	private String driverLicence;
	private String driverPhoto;
	private String busNoPlate;
	
	private String fromPlace;
	private String toPlace;
	private String fromDate;
	private String toDate;
	private String totalDate;
	private String pickUpPlace;
	private String dropPlace;
	private String startKM;
	private String endKM;
	private String totalKM;
	private String expectedtotalKM;
	private String perKMPrice;
	private String perDayPrice;
	private String tollPrice;
	private String totalPrice;
	
	private String advanceAmount;
	private String advanceAmountTransactionId;
	private String pendingAmount;
	
	private String bookingId;
	
	@Enumerated(EnumType.STRING)
	private IsActive isFullPaymentPaid= IsActive.N;//Y,N
	
	
	@Enumerated(EnumType.STRING)
	private IsActive isVenderAllocated = IsActive.N;//Y,N
	@Enumerated(EnumType.STRING)
	private YesNoPending isVenderAcceptedBooking = YesNoPending.P;//Y,N,P
	@Enumerated(EnumType.STRING)
	private BookingStatuses bookingStatus = BookingStatuses.Pending;//pending,cancel,complete,processing
	private String photo;
	@Enumerated(EnumType.STRING)
	private IsActive isActive = IsActive.Y;//Y,N
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMob() {
		return customerMob;
	}
	public void setCustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}
	public String getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(String noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
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
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getVenderBusId() {
		return venderBusId;
	}
	public void setVenderBusId(String venderBusId) {
		this.venderBusId = venderBusId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverMob() {
		return driverMob;
	}
	public void setDriverMob(String driverMob) {
		this.driverMob = driverMob;
	}
	public String getDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
	public String getDriverPhoto() {
		return driverPhoto;
	}
	public void setDriverPhoto(String driverPhoto) {
		this.driverPhoto = driverPhoto;
	}
	public String getBusNoPlate() {
		return busNoPlate;
	}
	public void setBusNoPlate(String busNoPlate) {
		this.busNoPlate = busNoPlate;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
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
	public String getTotalDate() {
		return totalDate;
	}
	public void setTotalDate(String totalDate) {
		this.totalDate = totalDate;
	}
	public String getPickUpPlace() {
		return pickUpPlace;
	}
	public void setPickUpPlace(String pickUpPlace) {
		this.pickUpPlace = pickUpPlace;
	}
	public String getDropPlace() {
		return dropPlace;
	}
	public void setDropPlace(String dropPlace) {
		this.dropPlace = dropPlace;
	}
	public String getStartKM() {
		return startKM;
	}
	public void setStartKM(String startKM) {
		this.startKM = startKM;
	}
	public String getEndKM() {
		return endKM;
	}
	public void setEndKM(String endKM) {
		this.endKM = endKM;
	}
	public String getTotalKM() {
		return totalKM;
	}
	public void setTotalKM(String totalKM) {
		this.totalKM = totalKM;
	}
	public String getPerKMPrice() {
		return perKMPrice;
	}
	public void setPerKMPrice(String perKMPrice) {
		this.perKMPrice = perKMPrice;
	}
	public String getPerDayPrice() {
		return perDayPrice;
	}
	public void setPerDayPrice(String perDayPrice) {
		this.perDayPrice = perDayPrice;
	}
	public String getTollPrice() {
		return tollPrice;
	}
	public void setTollPrice(String tollPrice) {
		this.tollPrice = tollPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public String getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(String pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public IsActive getIsFullPaymentPaid() {
		return isFullPaymentPaid;
	}
	public void setIsFullPaymentPaid(IsActive isFullPaymentPaid) {
		this.isFullPaymentPaid = isFullPaymentPaid;
	}
	public IsActive getIsVenderAllocated() {
		return isVenderAllocated;
	}
	public void setIsVenderAllocated(IsActive isVenderAllocated) {
		this.isVenderAllocated = isVenderAllocated;
	}
	public YesNoPending getIsVenderAcceptedBooking() {
		return isVenderAcceptedBooking;
	}
	public void setIsVenderAcceptedBooking(YesNoPending isVenderAcceptedBooking) {
		this.isVenderAcceptedBooking = isVenderAcceptedBooking;
	}
	public BookingStatuses getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatuses bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public IsActive getIsActive() {
		return isActive;
	}
	public void setIsActive(IsActive isActive) {
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
	
	public String getExpectedtotalKM() {
		return expectedtotalKM;
	}
	public void setExpectedtotalKM(String expectedtotalKM) {
		this.expectedtotalKM = expectedtotalKM;
	}
	public String getAdvanceAmountTransactionId() {
		return advanceAmountTransactionId;
	}
	public void setAdvanceAmountTransactionId(String advanceAmountTransactionId) {
		this.advanceAmountTransactionId = advanceAmountTransactionId;
	}
	
	public String getIsAc() {
		return isAc;
	}
	public void setIsAc(String isAc) {
		this.isAc = isAc;
	}
	
	public String getTypeOfTrip() {
		return typeOfTrip;
	}
	public void setTypeOfTrip(String typeOfTrip) {
		this.typeOfTrip = typeOfTrip;
	}
	public String getDestinations() {
		return destinations;
	}
	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}
	
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Booking() {
		super();
	}
	public Booking(int id, String customerId, String customerName, String customerMob, String noOfPassenger,
			String description, String busId, String seater, String type, String isAc, String typeOfTrip,
			String destinations, String venderId, String venderBusId, String driverName, String driverMob,
			String driverLicence, String driverPhoto, String busNoPlate, String fromPlace, String toPlace,
			String fromDate, String toDate, String totalDate, String pickUpPlace, String dropPlace, String startKM,
			String endKM, String totalKM, String expectedtotalKM, String perKMPrice, String perDayPrice,
			String tollPrice, String totalPrice, String advanceAmount, String advanceAmountTransactionId,
			String pendingAmount, IsActive isFullPaymentPaid, IsActive isVenderAllocated,
			YesNoPending isVenderAcceptedBooking, BookingStatuses bookingStatus, String photo, IsActive isActive,
			Date createAt, Date updateAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMob = customerMob;
		this.noOfPassenger = noOfPassenger;
		this.description = description;
		this.busId = busId;
		this.seater = seater;
		this.type = type;
		this.isAc = isAc;
		this.typeOfTrip = typeOfTrip;
		this.destinations = destinations;
		this.venderId = venderId;
		this.venderBusId = venderBusId;
		this.driverName = driverName;
		this.driverMob = driverMob;
		this.driverLicence = driverLicence;
		this.driverPhoto = driverPhoto;
		this.busNoPlate = busNoPlate;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalDate = totalDate;
		this.pickUpPlace = pickUpPlace;
		this.dropPlace = dropPlace;
		this.startKM = startKM;
		this.endKM = endKM;
		this.totalKM = totalKM;
		this.expectedtotalKM = expectedtotalKM;
		this.perKMPrice = perKMPrice;
		this.perDayPrice = perDayPrice;
		this.tollPrice = tollPrice;
		this.totalPrice = totalPrice;
		this.advanceAmount = advanceAmount;
		this.advanceAmountTransactionId = advanceAmountTransactionId;
		this.pendingAmount = pendingAmount;
		this.isFullPaymentPaid = isFullPaymentPaid;
		this.isVenderAllocated = isVenderAllocated;
		this.isVenderAcceptedBooking = isVenderAcceptedBooking;
		this.bookingStatus = bookingStatus;
		this.photo = photo;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerId=" + customerId + ", customerName=" + customerName + ", customerMob="
				+ customerMob + ", noOfPassenger=" + noOfPassenger + ", description=" + description + ", busId=" + busId
				+ ", seater=" + seater + ", type=" + type + ", isAc=" + isAc + ", typeOfTrip=" + typeOfTrip
				+ ", destinations=" + destinations + ", venderId=" + venderId + ", venderBusId=" + venderBusId
				+ ", driverName=" + driverName + ", driverMob=" + driverMob + ", driverLicence=" + driverLicence
				+ ", driverPhoto=" + driverPhoto + ", busNoPlate=" + busNoPlate + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", fromDate=" + fromDate + ", toDate=" + toDate + ", totalDate=" + totalDate
				+ ", pickUpPlace=" + pickUpPlace + ", dropPlace=" + dropPlace + ", startKM=" + startKM + ", endKM="
				+ endKM + ", totalKM=" + totalKM + ", expectedtotalKM=" + expectedtotalKM + ", perKMPrice=" + perKMPrice
				+ ", perDayPrice=" + perDayPrice + ", tollPrice=" + tollPrice + ", totalPrice=" + totalPrice
				+ ", advanceAmount=" + advanceAmount + ", advanceAmountTransactionId=" + advanceAmountTransactionId
				+ ", pendingAmount=" + pendingAmount + ", isFullPaymentPaid=" + isFullPaymentPaid
				+ ", isVenderAllocated=" + isVenderAllocated + ", isVenderAcceptedBooking=" + isVenderAcceptedBooking
				+ ", bookingStatus=" + bookingStatus + ", photo=" + photo + ", isActive=" + isActive + ", createAt="
				+ createAt + ", updateAt=" + updateAt + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}


	
}


