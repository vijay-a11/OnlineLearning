package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>  {

	List<Student> findByFirstNameContainingIgnoreCase(String searchQuery);

}
