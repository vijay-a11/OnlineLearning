package com.example.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Assignment;

import com.example.service.AssignmentService;
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("api/assignment/")
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentservice;
	
	@PostMapping("create")
	public ResponseEntity<?>createAssignment(@Valid @RequestBody Assignment assignment ){
		Assignment assignmentcheck=this.assignmentservice.createAssignment(assignment);
		if(assignmentcheck!=null) {
		return new ResponseEntity<Assignment>(assignmentcheck,HttpStatus.CREATED);
		
		}
		else {
			return new ResponseEntity<String>("Already exists",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("allAssignments")
	public ResponseEntity <List<Assignment>>getAllAssignment(){
		if(this.assignmentservice.getAllAssignment().size()>0) {
			return new ResponseEntity<List<Assignment>>(this.assignmentservice.getAllAssignment(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	
	}
}
	
	

	


