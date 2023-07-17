package com.tushar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tushar.Model.Buses;
import com.tushar.dto.Response;
import com.tushar.repository.BusRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Buses")
public class BusesController extends BaseControler {

	private static final Logger logger = LoggerFactory.getLogger(BusesController.class);

	@PostMapping("/addBuses")
	public ResponseEntity<Map> addBuses(@RequestParam(value = "photo", required = false) MultipartFile photo,
			@RequestParam("busName") String busName, @RequestParam("busDetails") String busDetails,
			@RequestParam("seater") String seater, @RequestParam("type") String type,
			@RequestParam("perExtraDayChange") String perExtraDayChange,
			@RequestParam("perKMPriceInCity") String perKMPriceInCity,
			@RequestParam("perKMPriceOutOfCity") String perKMPriceOutOfCity) {
		try {

			Buses buses = new Buses();
			buses.setCreateAt(new Date());
			buses.setBusName(busName);
			buses.setBusDetails(busDetails);
			buses.setSeater(seater);
			buses.setType(type);
			buses.setPerExtraDayChange(perExtraDayChange);
			buses.setPerKMPriceInCity(perKMPriceInCity);
			buses.setPerKMPriceOutOfCity(perKMPriceOutOfCity);

			busRepo.save(buses);
			int id = buses.getId();

			String filename = photo == null ? "" : fileStorageService.storeFile(photo, "BusesPhoto_" + id);
			buses.setPhoto(filename);

			busRepo.save(buses);

			Map m = new HashMap();
			m.put("status", true);
			m.put("message", "Success");
			m.put("id", id);
			return new ResponseEntity<Map>(m, HttpStatus.OK);

		} catch (Exception e) {
			Map m = new HashMap();
			m.put("status", false);
			m.put("error", e.getMessage());
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/BusesList")
	public ResponseEntity<Map> BusesList(HttpServletRequest req, HttpServletResponse res) {

		String path1 = req.getRequestURL().toString();
		path1 = path1.replace("BusBookingApp", "Bus_Booking_Admin_APP");
		String send_path = path1.split("/api/Buses/BusesList")[0] + "/images";

		Map m = new HashMap();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("buses", busRepo.findAllByOrderByIdDesc());
		m.put("status", true);
		m.put("basePath", send_path);
		// m.put("basePath", fileDownloadUri);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BusesById/{id}")
	public ResponseEntity<Map> BusesById(@PathVariable String id, HttpServletRequest req, HttpServletResponse res) {
		try {

			String path1 = req.getRequestURL().toString();
			path1 = path1.replace("BusBookingApp", "Bus_Booking_Admin_APP");
			String send_path = path1.split("/api/Buses/BusesById")[0] + "/images";
			Map m = new HashMap();
			m.put("data", busServices.getBus(Integer.parseInt(id)));
			m.put("status", true);
			m.put("basePath", send_path);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("e >>>" + e);
			Map m = new HashMap();
			m.put("status", false);
			m.put("error", e.getMessage());
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("updateBuses/{id}")
	public ResponseEntity<Map> updateBuses(@RequestBody Buses buses, @PathVariable String id) {

		Buses buses2 = busServices.getBus(Integer.parseInt(id));
		System.out.println("buses2 >" + buses2);

		buses2.setBusName(buses.getBusName());
		buses2.setBusDetails(buses.getBusDetails());
		buses2.setPerExtraDayChange(buses.getPerExtraDayChange());
		buses2.setPerKMPriceInCity(buses.getPerKMPriceInCity());
		buses2.setPerKMPriceOutOfCity(buses.getPerKMPriceOutOfCity());
		buses2.setSeater(buses.getSeater());
		buses2.setType(buses.getType());

		busServices.addBus(buses2);
		Map m = new HashMap();
		m.put("status", true);
		m.put("message", "Update Sucess");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@PostMapping("/updatePhoto")
	public ResponseEntity<Map> updatePhoto(@RequestParam(value = "photo", required = false) MultipartFile photo,
			@RequestParam("id") String id) {
		try {

			Buses buses = busServices.getBus(Integer.parseInt(id));
			System.out.println("buses >" + buses);

			String filename = photo == null ? "" : fileStorageService.storeFile(photo, "BusesPhoto_" + id);
			buses.setPhoto(filename);
			buses.setUpdateAt(new Date());
			busServices.addBus(buses);

			Map m = new HashMap();
			m.put("status", true);
			m.put("message", "Success");
			m.put("id", id);
			return new ResponseEntity<Map>(m, HttpStatus.OK);

		} catch (Exception e) {
			Map m = new HashMap();
			m.put("status", false);
			m.put("error", e.getMessage());
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* Bus Rent Apis start */

	// Retrive total Bus list
	@GetMapping("/retrieveTotalList")
	@ResponseBody
	public Response retrieveTotalList(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findAll();
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// Retrieve Bus List By Date
	@GetMapping("/retrieveListByDate")
	@ResponseBody
	public Response retrieveListByDate(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findByDate(buses.getDate());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// Retrieve Bus List By Bus Name
	@GetMapping("/retrieveListByBusName")
	@ResponseBody
	public Response retrieveListByBusName(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		Buses buses2 = busRepo.findByBusName(buses.getBusName());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// Retrieve Bus List By Bus Type
	@GetMapping("/retrieveListByType")
	@ResponseBody
	public Response retrieveListByType(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findByType(buses.getType());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// Retrieve List By Destination Start And Destination End
	@GetMapping("/retrieveListByDestinationStartAndDestinationEnd")
	@ResponseBody
	public Response retrieveListByDestinationStartAndDestinationEnd(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busServices.findByDestinationStartAndDestinationEnd(buses.getDestinationStart(),
				buses.getDestinationEnd());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// retrieve by Bus type ANd Bus Name
	@GetMapping("/retrieveListByTypeAndBusName")
	@ResponseBody
	public Response retrieveListByTypeAndBusName(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findByTypeAndBusName(buses.getType(), buses.getBusName());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	// retrieve bus list by bus type, name and date
	@GetMapping("/retrieveListByTypeAndBusNameAndDate")
	@ResponseBody
	public Response retrieveListByTypeAndBusNameAndDate(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findByTypeAndBusNameAndDate(buses.getType(), buses.getBusName(), buses.getDate());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}

	@GetMapping("/retrieveListByTypeAndBusNameAndDateAndDestinationStartAndDestinationEnd")
	@ResponseBody
	public Response retrieveListByTypeAndBusNameAndDateAndDestinationStartAndDestinationEnd(@RequestBody Buses buses) {
		Response response = new Response();
		response.setStatus("not successfull");
		response.setMessage("data not found");
		List<Buses> buses2 = busRepo.findByTypeAndBusNameAndDateAndDestinationStartAndDestinationEnd(buses.getType(),
				buses.getBusName(), buses.getDate(), buses.getDestinationStart(), buses.getDestinationEnd());
		if (buses2 != null) {
			response.setData(buses2);
			response.setStatus("success");
			response.setMessage("data retrieved");
		}
		return response;
	}
}
