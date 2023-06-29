package com.tushar.services;

import org.springframework.stereotype.Service;

import com.tushar.Model.OneWayTrip;


@Service
public class OneWayTripService  extends BaseServices{

	public void save(OneWayTrip oneWayTrip) {
		
		oneWayTripRepo.save(oneWayTrip);	
	}

	
	public void delete(OneWayTrip oneWayTrip) {
		
		oneWayTripRepo.delete(oneWayTrip);
	}
	
}
