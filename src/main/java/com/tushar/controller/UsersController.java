package com.tushar.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.Model.Users;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/User")
public class UsersController extends BaseControler{
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@PostMapping("/AddUsers")
	public ResponseEntity<Map> AddAdmin(@RequestBody Users admin) {
		Users a = null;
		Map m=new HashMap();
		try {
			a = userRepo.findByUsername(admin.getUsername());
			System.out.println("a >"+a);
		} catch (Exception e) {
			System.out.println("User Not found!!!");
		}
		if (a == null) {
			System.out.println("in");
			admin.setCreateAt(new Date());
			userRepo.save(admin);
			m.put("status", true);
			m.put("message","Success");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}else {
			m.put("status", false);
			m.put("message","User Already Available");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
	}
	
	@GetMapping("/UsersList")
	public ResponseEntity<Map> Users() {
		Map m=new HashMap();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("Users", userRepo.findAllByOrderByIdDesc());
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	@GetMapping("/UserByRole")
	public ResponseEntity<Map> UserByRole(@RequestParam String role) {
		//String role="sell-person";
		Map m=new HashMap();
		List<Users> admin=userRepo.findAllByOrderByIdDesc();
		admin=admin.stream().filter(a -> a.getRole().equals(role)).collect(Collectors.toList());
		
		m.put("Users",admin);
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	 @GetMapping("/UserById/{id}")
	    public ResponseEntity<Map> UserByID(@PathVariable String id){
	    	try {
		    	Map m=new HashMap();
				m.put("data", usersServices.getUsers(Integer.parseInt(id)));
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
	 
	@DeleteMapping("/UserDelete")
	public ResponseEntity<Map> adminsDelete(@RequestParam String id) {
		System.out.println("in delete >"+id);
		Map m= new HashMap();
		try {
			userRepo.deleteById(Integer.parseInt(id));
		}catch (Exception e) {
			m.put("status", false);
			m.put("message","delete not Sucess");
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
		m.put("status", true);
		m.put("message","delete Sucess");
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<Map> updateAdmin(@RequestBody Users users,@PathVariable String id) {
		
		Users user2=usersServices.getUsers(Integer.parseInt(id));
		System.out.println("admins2 >"+user2);
		
		user2.setName(users.getName());
		user2.setRole(users.getRole());
		user2.setUsername(users.getUsername());
		user2.setPassword(users.getPassword());
		
		usersServices.addUser(user2);	
		Map m= new HashMap();
		m.put("status", true);
		m.put("message","Update Sucess");
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<Map> Login(@RequestBody Users user) {
		String username=user.getUsername();
		String pass=user.getPassword();
		System.out.println("user >"+username);
		System.out.println("pass >"+pass);
		Map m= new HashMap();
		System.out.println("Login");
		Users a = null;
		Users admin=new Users();
		try {
			a = userRepo.findByUsername(username);
			System.out.println("a >"+a);
			
		} catch (Exception e) {
			System.out.println("User Not found!!!");

		}
		System.out.println("a >> >"+a);
		if (a != null && a.getPassword().equals(pass)) {
			System.out.println("in");
			a.setStatus("success");
			m.put("status", true);
			m.put("message","Login Sucess");
			m.put("Users", a);
			return new ResponseEntity<Map>(m,HttpStatus.OK);
		}
		admin.setStatus("Not success");
		m.put("status", false);
		m.put("message","Invalide UserName and Password");
		m.put("Users", admin);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        
        // Try to determine file's content type
        String contentType = null;
        try {
        	System.out.println("path >>"+resource.getFile().getAbsolutePath());
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
