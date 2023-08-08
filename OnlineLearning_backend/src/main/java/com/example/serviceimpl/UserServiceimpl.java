package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userrepository;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		 User user = userrepository.findByEmail(email);
         if (user != null && passwordMatches(user, password)) 
         {
	       return user;
	     } 
         else {
	            
	            return null;
	        }
	    }

	   private boolean passwordMatches(User user, String providedPassword) {
	       return user.getPassword().equals(providedPassword);
	    }
	
	}

	


