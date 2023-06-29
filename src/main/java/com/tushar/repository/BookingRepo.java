package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Booking;
import com.tushar.enumClasses.BookingStatuses;
import com.tushar.enumClasses.IsActive;
import com.tushar.enumClasses.YesNoPending;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

	List<Booking> findByCustomerIdOrderByIdDesc(String customerID);
	List<Booking> findByCustomerIdAndBookingStatusOrderByIdDesc(String customerID, BookingStatuses bookingStatus);
	
	List<Booking> findByVenderIdOrderByIdDesc(String venderID);
	List<Booking> findByVenderIdAndIsVenderAcceptedBookingOrderByIdDesc(String venderID,IsActive isVenderAcceptedBooking);
	List<Booking> findByVenderIdAndBookingStatusOrderByIdDesc(String venderID,BookingStatuses bookingStatus);
	Booking findByVenderIdAndIdOrderByIdDesc(String venderID,int id);
	
	List<Booking> findByBookingStatusOrderByIdDesc(BookingStatuses bookingStatus);
	List<Booking> findByIsVenderAllocatedOrderByIdDesc(IsActive isVenderAllocated);
	
	List<Booking> findByIsVenderAllocatedAndIsVenderAcceptedBookingOrderByIdDesc(IsActive isVenderAllocated,YesNoPending isVenderAcceptedBooking);
	//Booking findByID(String id);
	
	List<Booking> findAllByOrderByIdDesc();

}
