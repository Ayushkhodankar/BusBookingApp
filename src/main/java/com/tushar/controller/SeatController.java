package com.tushar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tushar.Model.Seat;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Seat")
public class SeatController extends BaseControler {
	
	@PostMapping("/addSeat")
	public ResponseEntity<Map> saveDeaddSeattails(@RequestBody Seat seat) {

		Map<String, Object> m = new HashMap<>();
		try {
			Seat saveSeat = seatRepository.save(seat);
			m.put("Message", "User Details Saved Successfully");
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			m.put("Users List", "List Can't Be Retrieved");
			m.put("status", false);
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//retrieve all the seat list
	@GetMapping("/SeatsList")
	public ResponseEntity<Map> SeatsList() {

		Map<String, Object> m = new HashMap<>();
		try {
			m.put("Seat List", seatRepository.findAll());
			m.put("status", true);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
		}
	}
	
	//delete the seats
	@PostMapping("/deleteSeat")
	public ResponseEntity<String> deleteSeat(@RequestBody Seat seat) {
	
		int i = seatRepository.deleteByid(seat.getId());
		if(i > 0) {
		      return ResponseEntity.ok("Data Deleted Successfully..!!");
			}
			else
				return ResponseEntity.badRequest().body("No Data Deleted");
	        }

}
