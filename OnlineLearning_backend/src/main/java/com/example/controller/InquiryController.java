package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Inquiry;
import com.example.service.InquiryService;
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("api/inquiry/")
public class InquiryController {
	 @Autowired
	 private InquiryService inquiryservice;
	 
	 @PostMapping("create")
	    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
	        Inquiry createdInquiry = inquiryservice.createInquiry(inquiry);
	        return new ResponseEntity<>(createdInquiry, HttpStatus.CREATED);
	    }

	    
	}


