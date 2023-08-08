package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry,Long> {

}
