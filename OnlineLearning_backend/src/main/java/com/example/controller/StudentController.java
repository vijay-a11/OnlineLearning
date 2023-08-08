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
import com.example.entity.Student;

import com.example.service.StudentService;


@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")

@RequestMapping("api/student/")
public class StudentController {
	@Autowired
	private StudentService studentservice;

	@PostMapping("add")
	public ResponseEntity<?>addStudent(@Valid @RequestBody Student student ){
		Student studentcheck=this.studentservice.addStudent(student);
		if(studentcheck!=null) {
			return new ResponseEntity<Student>(studentcheck,HttpStatus.CREATED);
		
		}
		else {
			return new ResponseEntity<String>("UserName and Password doesnt match",HttpStatus.BAD_REQUEST);
		}

	}
	 
  @GetMapping("allStudents")
	public ResponseEntity <List<Student>>getAllStudent(){
		if(this.studentservice.getAllStudent().size()>0) {
			return new ResponseEntity<List<Student>>(this.studentservice.getAllStudent(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("{stdid}")
	   public ResponseEntity<Student> getStudentById(@PathVariable long stdid) {
		 
     Student student= studentservice.getStudentById(stdid);
     if (student != null) {
         return new ResponseEntity<>(student, HttpStatus.OK);
     }
     else {
     	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     	
     }
     
 }
	@GetMapping("/get/{stdid}/course")
    public ResponseEntity<List<Course>> getCourseByStudent(@PathVariable long stdid) {
    	
       List<Course> course = studentservice.getCourseByStudentId(stdid);
        if (course!= null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

@PutMapping("{stdid}")
	public ResponseEntity<?>updateStudent(@PathVariable long stdid,@Valid @RequestBody Student student)
	{
		Student studentcheck=this.studentservice.updateStudent(student,stdid);
		if(studentcheck!=null) {
			return new ResponseEntity<Student>(studentcheck,HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("{stdid}")
	public List<Student> deleteStudentById(@PathVariable Long stdid)
	{
		studentservice.deleteStudent(stdid);
		return studentservice.getAllStudent();
	}
		
	
		

}
