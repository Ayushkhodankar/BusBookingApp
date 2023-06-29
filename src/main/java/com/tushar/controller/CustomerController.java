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

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/Customer")
public class CustomerController extends BaseControler{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/Login")
	public ResponseEntity<Map> AddCustomer(@RequestParam("MobileNo") String MobileNo) {
		Customers a = null;
		Map m=new HashMap();
		try {
			a = customersRepo.findByMob(MobileNo);
			System.out.println("a >"+a);
		} catch (Exception e) {
			System.out.println("User Not found!!!");
		}
		if (a == null) {
			System.out.println("in");
			a=new Customers();
			a.setCreateAt(new Date());
			a.setIsActive('Y');
			a.setMob(MobileNo);
			customersRepo.save(a);
			m.put("status", false);
			m.put("Customer", a);
			m.put("message","Add New Customer Success");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}else {
			m.put("status", true);
			m.put("Customer", a);
			m.put("message","Login Success");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
	}
	
	@GetMapping("/CustomersList")
	public ResponseEntity<Map> CustomersList() {
		Map m=new HashMap();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("Customers", customersRepo.findAllByOrderByIdDesc());
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	 @GetMapping("/CustomerById/{id}")
	    public ResponseEntity<Map> CustomerById(@PathVariable String id){
	    	try {
		    	Map m=new HashMap();
				m.put("data", customerServices.getCustomer(Integer.parseInt(id)));
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
	 
	 @PutMapping("updateCustomer/{id}")
		public ResponseEntity<Map> updateCustomer(@RequestBody Customers customer,@PathVariable String id) {
			
			Customers customer2=customerServices.getCustomer(Integer.parseInt(id));
			System.out.println("customer2 >"+customer2);
			
			customer2.setName(customer.getName());
			customer2.setGender(customer.getGender());
			customer2.setDob(customer.getDob());
			customer2.setEmail(customer.getEmail());
			customer2.setAdrs(customer.getAdrs());
			customer2.setPincode(customer.getPincode());
			
			customerServices.addCustomer(customer2);	
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
				
					Customers customers=customerServices.getCustomer(Integer.parseInt(id));
					System.out.println("customers >"+customers);
				
					String filename = photo==null?"": fileStorageService.storeFile(photo,"CustomersPhoto_"+id);
					customers.setPhoto(filename);
					customerServices.addCustomer(customers);	
					
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
