package com.tushar.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tushar.Model.RoundTrip;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/RoundTrip")
public class RoundTripController extends BaseControler {

	@PostMapping("/AddRoundTrip")
	@ResponseBody
	public void AddRoundTrip(@RequestBody RoundTrip roundTrip) throws Exception
	{
		 roundTripServices.save(roundTrip);
		 if(roundTrip!=null){
			 
		 }		 
	}
	
	
	@PostMapping("/DeleteRoundTrip")
	@ResponseBody
	public void DeleteRoundTrip(@RequestBody RoundTrip roundTrip)
	{
		roundTripServices.delete(roundTrip);
	}

	
	@PostMapping("/UpdateRoundTrip")
	@ResponseBody
	public RoundTrip UpdateRoundTrip(@RequestBody RoundTrip roundTrip)
	{
		RoundTrip list= roundTripServices.UpdateThroughid(roundTrip);
		return list;
	}
	
	
	
	
	/*
	 * pickup":"Nagpur", "destation":"Pune", "returnLocation": "Nagpur",
	 * "passangerNo":"2", "fromDate":"13/02/2023", "toDate":"14/02/2023",
	 * "varient":"Ac"
	 */
	 
	 
	 
					    
}
	

