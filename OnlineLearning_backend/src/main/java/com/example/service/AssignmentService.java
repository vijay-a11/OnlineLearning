package com.example.service;

import java.util.List;

import com.example.entity.Assignment;

public interface AssignmentService {
	 Assignment createAssignment(Assignment assignment);
	 List<Assignment> getAllAssignment();
	 Assignment getAssignmentById(long id);
	}
