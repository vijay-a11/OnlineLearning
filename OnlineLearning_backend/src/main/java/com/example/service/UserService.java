package com.example.service;


import com.example.entity.User;

public interface UserService {
	
	public User registerUser(User user);
	public User loginUser(String email, String password);



}
