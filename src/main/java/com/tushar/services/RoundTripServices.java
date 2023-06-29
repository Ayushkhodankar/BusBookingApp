package com.tushar.services;

import org.springframework.stereotype.Service;

import com.tushar.Model.RoundTrip;


@Service
public class RoundTripServices extends BaseServices {

	public void save(RoundTrip roundTrip) {
		
		roundTripRepo.save(roundTrip);
	}

	public void delete(RoundTrip roundTrip) {
		
		roundTripRepo.delete(roundTrip);
	}

	public RoundTrip UpdateThroughid(RoundTrip roundTrip) {
		RoundTrip list=roundTripRepo.saveAndFlush(roundTrip);
		return list;
	}

	

	
	
}
