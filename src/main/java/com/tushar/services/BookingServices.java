package com.tushar.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.Booking;


@Service
public class BookingServices extends BaseServices{

	public void addBooking(Booking booking) {
		bookingRepo.save(booking);
	}
	
	public Booking getBooking(int id) {
		 
		Optional<Booking> opt= bookingRepo.findById(id);
		Booking booking=opt.get();
		booking.setPhoto(FileStorageService.ImagePath(booking.getPhoto()));
		return booking;
	}
	
	public Booking getBookingByVender(String venderId,int id) {
		 
		Optional<Booking> opt= Optional.of(bookingRepo.findByVenderIdAndIdOrderByIdDesc(venderId, id));
		Booking booking=opt.get();
		booking.setPhoto(FileStorageService.ImagePath(booking.getPhoto()));
		return booking;
	}
}
