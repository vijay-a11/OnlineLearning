package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="inquirytable")

public class Inquiry {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long inquiryid;
	    
	    @NotEmpty
		@Column(name="useremail")
	    private String email;
	    
	    @NotEmpty
	    @Column(name="userquery")
	    private String message;
	    
		public Inquiry() {
			super();
		}
		
       public Inquiry(long inquiryid, @NotEmpty String email, @NotEmpty String message) {
			super();
			this.inquiryid = inquiryid;
			this.email = email;
			this.message = message;
		}
      public long getInquiryid() {
			return inquiryid;
		}
		public void setInquiryid(long inquiryid) {
			this.inquiryid = inquiryid;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Inquiry [inquiryid=" + inquiryid + ",email=" + email + ", message=" + message
					+ "]";
		}
		
	    
	  
		
	    
	   
	}


