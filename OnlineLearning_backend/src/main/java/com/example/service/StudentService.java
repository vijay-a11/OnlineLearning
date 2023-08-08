package com.example.service;

import java.util.List;

import com.example.entity.Course;
import com.example.entity.Student;


public interface StudentService {
	public Student addStudent(Student student);

	List<Student>getAllStudent();
	Student getStudentById(long stdid);
	Student updateStudent(Student student,long stdid);
	void deleteStudent(Long stdid);
	public List<Course> getCourseByStudentId(long stdid);
    public List<Student> searchStudents(String searchQuery);
	

}
