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

import com.tushar.Model.Customers;
import com.tushar.Model.Venders;
import com.tushar.repository.VenderRepo;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/Vender")
public class VenderController extends BaseControler{
	
	private static final Logger logger = LoggerFactory.getLogger(VenderController.class);

	@PostMapping("/Login")
	public ResponseEntity<Map> AddVender(@RequestParam("MobileNo") String MobileNo) {
		Venders a = null;
		Map m=new HashMap();
		try {
			a = venderRepo.findByMob(MobileNo);
			System.out.println("a >"+a);
		} catch (Exception e) {
			System.out.println("User Not found!!!");
		}
		if (a == null) {
			a= new Venders();
			System.out.println("in");
			a.setCreateAt(new Date());
			a.setIsActive('Y');
			a.setMob(MobileNo);
			venderRepo.save(a);
			m.put("status", false);
			m.put("Vender", a);
			m.put("message","Add New Vender Success");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}else {
			m.put("status", true);
			m.put("Vender", a);
			m.put("message","Login Success");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
	}
	
	@GetMapping("/VenderList")
	public ResponseEntity<Map> VenderList() {
		Map m=new HashMap();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("Vender", venderRepo.findAllByOrderByIdDesc());
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	 @GetMapping("/VenderById/{id}")
	    public ResponseEntity<Map> VenderById(@PathVariable String id){
	    	try {
		    	Map m=new HashMap();
				m.put("data", venderServices.getVender(Integer.parseInt(id)));
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
	 
	 @PutMapping("updateVender/{id}")
		public ResponseEntity<Map> updateVender(@RequestBody Venders venders,@PathVariable String id) {
			
			Venders venders2=venderServices.getVender(Integer.parseInt(id));
			System.out.println("venders2 >"+venders2);
			
			venders2.setName(venders.getName());
			venders2.setEmail(venders.getEmail());
			venders2.setAdrs(venders.getAdrs());
			venders2.setPincode(venders.getPincode());
			venders2.setPanCard(venders.getPanCard());
			venders2.setGstNo(venders.getGstNo());
			
			venderServices.addVender(venders2);	
			Map m= new HashMap();
			m.put("status", true);
			m.put("message","Update Sucess");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
	 
	 
	 	@PostMapping("/addPhoto")
		public ResponseEntity<Map>  addPhoto(
				@RequestParam(value ="photo",required = false) MultipartFile photo,
				@RequestParam("id") String id) {
			try {
				
					Venders venders2=venderServices.getVender(Integer.parseInt(id));
					System.out.println("venders2 >"+venders2);
				
					String filename = photo==null?"": fileStorageService.storeFile(photo,"VenderPhoto_"+id);
					venders2.setLogo(filename);
					venderServices.addVender(venders2);	
					
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
