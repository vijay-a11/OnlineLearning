package com.example.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.entity.Inquiry;
import com.example.repository.InquiryRepository;
import com.example.service.InquiryService;

@Service
public class InquiryServiceimpl implements InquiryService   {
	    @Autowired
	    private InquiryRepository inquiryrepository;
	    @Override
		public Inquiry createInquiry(Inquiry inquiry) {
			// TODO Auto-generated method stub
			return inquiryrepository.save(inquiry);
		}
        

	    
	}


