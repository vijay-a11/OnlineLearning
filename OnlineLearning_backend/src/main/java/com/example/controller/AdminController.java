package com.example.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Admin;
import com.example.entity.LoginRequest;
import com.example.service.AdminService;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("api/admin/")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@PostMapping("register")
	public ResponseEntity<?>registerAdmin(@Valid @RequestBody Admin admin){
		Admin admincheck=this.adminservice.registerAdmin(admin);
		if(admincheck!=null) {
			return new ResponseEntity<Admin>(admincheck,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("UserName and Password doesnt match",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("login")
	
	 public ResponseEntity<Admin> loginAdmin(@RequestBody LoginRequest loginRequest) {
	        String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();

	       
	        Admin authenticatedAdmin = this.adminservice.loginAdmin(email, password);
	        if (authenticatedAdmin != null) {
	            return new ResponseEntity<>(authenticatedAdmin, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }
	    }
	
    
}








