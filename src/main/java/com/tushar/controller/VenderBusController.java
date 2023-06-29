package com.tushar.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tushar.Model.VenderBuses;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/Vender/Buses")
public class VenderBusController extends BaseControler{
	
	private static final Logger logger = LoggerFactory.getLogger(VenderBusController.class);
	
	@PostMapping("/addBuses")
	public ResponseEntity<Map>  addBuses(
			@RequestParam(value ="rcPic",required = false) MultipartFile rcPic,
			@RequestParam(value ="incurencePic",required = false) MultipartFile incurencePic,
			@RequestParam(value ="photo",required = false) MultipartFile photo,
			@RequestParam("venderId") String venderId,
			@RequestParam("busID") String busID,
			@RequestParam("busDetails") String busDetails,
			@RequestParam("rcNo") String rcNo,
			@RequestParam("incurenceNo") String incurenceNo
			) {
		try {
			
				VenderBuses buses = new VenderBuses();
				buses.setCreateAt(new Date());
				buses.setVenderId(venderId);
				buses.setBusID(busID);
				buses.setBusDetails(busDetails);
				buses.setRcNo(rcNo);
				buses.setIncurenceNo(incurenceNo);
				
				venderBusRepo.save(buses);
				int id=buses.getId();
			
				String filename = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_"+id);
				String filename2 = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_rcPic_"+id);
				String filename3 = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_incurencePic_"+id);
				buses.setPhoto(filename);
				buses.setRcPic(filename2);
				buses.setIncurencePic(filename3);
				
				venderBusRepo.save(buses);
				
				Map m=new HashMap();
				m.put("status", true);
				m.put("message","Success");
				m.put("id",id);
				return new ResponseEntity<Map>(m,HttpStatus.OK);
			
		} catch (Exception e) {
			Map m=new HashMap();
			m.put("status", false);
			m.put("error",e.getMessage());
			return new ResponseEntity<Map>(m,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/BusesList/{VenderId}")
	public ResponseEntity<Map> BusesList(@PathVariable String VenderId) {
		Map m=new HashMap();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("buses", venderBusRepo.findByVenderId(VenderId));
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	@GetMapping("/BusesById/{id}")
    public ResponseEntity<Map> BusesById(@PathVariable String id){
    	try {
	    	Map m=new HashMap();
			m.put("data", venderBusServices.getBus(Integer.parseInt(id)));
			m.put("status", true);
			return new ResponseEntity<Map>(m,HttpStatus.OK);
    	} catch (Exception e) {
			System.out.println("e >>>"+e);
			Map m=new HashMap();
			m.put("status", false);
			m.put("error",e.getMessage());
			return new ResponseEntity<Map>(m,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	 @PutMapping("/updateBuses/{id}")
		public ResponseEntity<Map> updateBuses(@RequestBody VenderBuses buses,@PathVariable String id) {
			
			VenderBuses buses2=venderBusServices.getBus(Integer.parseInt(id));
			System.out.println("buses2 >"+buses2);
			
			buses2.setBusDetails(buses.getBusDetails());
			buses2.setBusID(buses.getBusID());
			buses2.setBusNoPlate(buses.getBusNoPlate());
			buses2.setIncurenceNo(buses.getIncurenceNo());
			buses2.setRcNo(buses.getRcNo());
			buses2.setUpdateAt(new Date());
			
			venderBusServices.addBus(buses2);	
			Map m= new HashMap();
			m.put("status", true);
			m.put("message","Update Sucess");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
	 
	 @PostMapping("/updatePhoto")
		public ResponseEntity<Map>  updatePhoto(
				@RequestParam(value ="photo",required = false) MultipartFile photo,
				@RequestParam(value ="rcPic",required = false) MultipartFile rcPic,
				@RequestParam(value ="incurencePic",required = false) MultipartFile incurencePic,
				@RequestParam("id") String id) {
			try {
				
					VenderBuses buses=venderBusServices.getBus(Integer.parseInt(id));
					System.out.println("buses >"+buses);
				
					String filename = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_"+id);
					String filename2 = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_rcPic_"+id);
					String filename3 = photo==null?"": fileStorageService.storeFile(photo,"VenderBusesPhoto_incurencePic_"+id);
					/* buses.setPhoto(filename); */
					buses.setUpdateAt(new Date());
					venderBusServices.addBus(buses);	
					
					Map m=new HashMap();
					m.put("status", true);
					m.put("message","Success");
					m.put("id",id);
					return new ResponseEntity<Map>(m,HttpStatus.OK);
				
			} catch (Exception e) {
				Map m=new HashMap();
				m.put("status", false);
				m.put("error",e.getMessage());
				return new ResponseEntity<Map>(m,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}


}
