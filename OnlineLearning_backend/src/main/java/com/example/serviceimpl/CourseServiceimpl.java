package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;

import com.example.service.CourseService;

@Service
public class CourseServiceimpl implements CourseService {
	@Autowired
	private CourseRepository courserepository;
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Course addCourse(Course course,long stdid) {
		// TODO Auto-generated method stub
		
		Student student=studentrepository.findById(stdid).orElse(null);
	    
	    if (student != null) {
	        course.setStudent(student);
	        return courserepository.save(course);
	    }
	    
	    return null;
	}
		
		


	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return this.courserepository.findAll();
	}
	@Override
	public Course getCourseById(long courseid) {
		// TODO Auto-generated method stub
		Course existingcourse=this.courserepository.findById(courseid).orElseThrow(()->new ResourceNotFoundException("Course","Id",courseid));
		return existingcourse;
	}
	
	@Override
	public Course updateCourse(Course course, long courseid) {
		// TODO Auto-generated method stub
		Course existingcourse = courserepository.findById(courseid).orElse(null);
	    
	    if (existingcourse != null) {
	    	
	        Student student=studentrepository.findById(course.getStudent().getStdid()).orElse(null);
	        
	        if (student != null) {
	            existingcourse.setStudent(student);
	        }
	    existingcourse.setName(course.getName());
        existingcourse.setDescription(course.getDescription());
        return courserepository.save(existingcourse);
		
	}
	
	return null;
	}

	@Override
	public void deleteCourse(Long courseid){
		// TODO Auto-generated method stub
		Course existingcourse=getCourseById(courseid);
		this.courserepository.delete(existingcourse);
		
	}






	

	 
}


	