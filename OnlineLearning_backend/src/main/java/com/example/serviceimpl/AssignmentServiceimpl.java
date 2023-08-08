package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Assignment;

import com.example.exception.ResourceNotFoundException;
import com.example.repository.AssignmentRepository;
import com.example.service.AssignmentService;

@Service
public class AssignmentServiceimpl implements AssignmentService {
	@Autowired
	private AssignmentRepository assignmentrepository;


	@Override
	public Assignment createAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return assignmentrepository.save(assignment);
	}
	@Override
	public List<Assignment> getAllAssignment() {
		// TODO Auto-generated method stub
		return this.assignmentrepository.findAll();
	}
	@Override
	public Assignment getAssignmentById(long id) {
		// TODO Auto-generated method stub
		Assignment existingassignment=this.assignmentrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Assignment","Id",id));
		return existingassignment;
	}
	
	  
}





	
	
		
	
	



	


	
		
	


