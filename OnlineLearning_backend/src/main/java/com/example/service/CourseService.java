package com.example.service;

import java.util.List;

import com.example.entity.Course;



public interface CourseService {

	public Course addCourse(Course course,long stdid);
	List<Course>getAllCourse();
	Course getCourseById(long courseid);
	Course updateCourse(Course course,long  courseid);
	void deleteCourse(Long courseid);
	
	

}
