package com.tushar.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.Model.OneWayTrip;

 
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/onewayTrip")
public class OneWayTripController  extends BaseControler{
	
	@PostMapping("/AddOneWayTrip")
	@ResponseBody
	public void OneWayTrip(@RequestBody OneWayTrip oneWayTrip)
	{
		if(oneWayTrip!=null){
		}
		 oneWayTripService.save(oneWayTrip);
	}
	
	
	@PostMapping("/DeleteonewayTrip")
	@ResponseBody
	public void DeletTrip(@RequestBody OneWayTrip  oneWayTrip)
	{
		oneWayTripService.delete(oneWayTrip);
	}
	
	
	/*
	 * "id":"1", "pickup":"Nagpur", "destination":"Pune", "noofPassanger":"2",
	 * "fromDate":"14/02/2023", "toDate":"15/02/2023", "varient":"Ac"
	 */
	 
}




