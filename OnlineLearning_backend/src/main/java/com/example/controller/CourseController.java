package com.example.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.service.CourseService;
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("api/courses/")
public class CourseController {
	@Autowired
	private CourseService courseservice;
	
	@PostMapping("add/{stdid}")
	public ResponseEntity<?>addCourse(@PathVariable("stdid") long stdid, @Valid @RequestBody Course course ){
		System.out.println("addCoursecontroller");
		Course coursecheck=this.courseservice.addCourse(course,stdid);
		if(coursecheck!=null) {
			return new ResponseEntity<Course>(coursecheck,HttpStatus.CREATED);
		
		}
		else {
			return new ResponseEntity<String>("Already exists",HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("allCourses")
	public ResponseEntity<Iterable<Course>> getAllCourses() {
        Iterable<Course> courses = courseservice.getAllCourse();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

	@GetMapping("{courseid}")
	 public ResponseEntity<Course> getCourseById(@PathVariable long courseid) {
		 
        Course course= courseservice.getCourseById(courseid);
        if (course!= null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        	
        }
        
    }
	
	
	@PutMapping("{courseid}")
	public ResponseEntity<?>updateCourse(@PathVariable long courseid,@Valid @RequestBody Course course)
	{
		Course coursecheck=this.courseservice.updateCourse(course,courseid);
		if(coursecheck!=null) {
			return new ResponseEntity<Course>(coursecheck,HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{courseid}")
	public List<Course> deleteCourseById(@PathVariable Long courseid)
	{
		courseservice.deleteCourse(courseid);
		return courseservice.getAllCourse();
	}
	}


