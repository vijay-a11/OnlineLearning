package com.example.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {
	@Autowired
	private StudentRepository studentrepository;


	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		if(student.getPassword().equals(student.getConfirmPassword())) {
			return studentrepository.save(student);
		}else {
			return null;
			
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return this.studentrepository.findAll();
	}

	@Override
	public Student getStudentById(long stdid) {
		// TODO Auto-generated method stub
		Student existingstudent=this.studentrepository.findById(stdid).orElseThrow(()->new ResourceNotFoundException("Student","Id",stdid));
		return existingstudent;
		}
	

	@Override
	public Student updateStudent(Student student, long stdid) {
		// TODO Auto-generated method stub
		Student existingstudent=getStudentById(stdid);
		existingstudent.setFirstName(student.getFirstName());
		existingstudent.setLastName(student.getLastName());
		existingstudent.setUserName(student.getUserName());
		existingstudent.setPassword(student.getPassword());
		existingstudent.setConfirmPassword(student.getConfirmPassword());
		existingstudent.setEmail(student.getEmail());
		existingstudent.setMobileNo(student.getMobileNo());
		
		return studentrepository.save(existingstudent);
	}

	@Override
	public void deleteStudent(Long stdid) {
		// TODO Auto-generated method stub
		Student existingstudent=getStudentById(stdid);
		this.studentrepository.delete(existingstudent);
		
		
	}

	@Override
	public List<Course> getCourseByStudentId(long stdid) {
		// TODO Auto-generated method stub
		Student student = studentrepository.findById(stdid).orElse(null);
	    if ( student!= null) {
	        return student.getCourse();
	    }
	    
	    return null;
	
	}
  @Override
	public List<Student> searchStudents(String searchQuery) {
		// TODO Auto-generated method stub
		 return studentrepository.findByFirstNameContainingIgnoreCase(searchQuery);
	}
	}


