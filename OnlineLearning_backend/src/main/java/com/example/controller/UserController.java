package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.LoginRequest;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RequestMapping()
public class UserController {
	
	 @Autowired
	 private UserService userservice;

	    @PostMapping("/register")
	    public ResponseEntity<?> registerUser(@RequestBody User user) {
	    		User check=this.userservice.registerUser(user);
	    		if(check!=null) {
	    			return new ResponseEntity<>(check,HttpStatus.CREATED);
	    		
	    		}
	    		else {
	    			return new ResponseEntity<String>("UserName and Password doesnt match",HttpStatus.BAD_REQUEST);
	    		}

	    	}
	    @PostMapping("/login")
	    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
	        String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();
	        User authenticatedUser = this.userservice.loginUser(email, password);
	        if (authenticatedUser != null) {
	            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
	        }
	    }

	    
	       
	       


	}


