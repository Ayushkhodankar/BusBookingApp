package com.tushar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.Booking;
import com.tushar.Model.Booking.SeatDetail;
import com.tushar.Model.Seat;
import com.tushar.repository.SeatRepository;


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

	public void bookSeats(String customerId, List<SeatDetail> seatDetails) throws Exception {
		 for (Booking.SeatDetail seatDetail : seatDetails) {
	            Seat seat = seatRepository.findBySeatNumber(seatDetail.getSeatNumber());

	            if (seat == null) {
	                throw new Exception("Invalid seat number: " + seatDetail.getSeatNumber());
	            }

	            if (seat.isBooked()) {
	                throw new Exception("Seat " + seatDetail.getSeatNumber() + " is already booked");
	            }
	            
	            seat.setCustomerId(customerId);
	            seat.setBooked(true);
	            seat.setPassengerName(seatDetail.getPassengerName());
	            seat.setPassengerLastName(seatDetail.getPassengerLastName());
	            seat.setPassengerEmail(seatDetail.getPassengerEmail());
	            seat.setPassengerMob(seatDetail.getPassengerMob());
	            seat.setPassengerGender(seatDetail.getPassengerGender());
	            seat.setPassengerIdType(seatDetail.getPassengerIdType());

	            seatRepository.save(seat);
		
	}
	}
	
}
