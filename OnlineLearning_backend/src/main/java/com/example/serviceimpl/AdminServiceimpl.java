package com.example.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;

@Service
public class AdminServiceimpl implements AdminService {
	@Autowired
		private AdminRepository adminrepository;

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admin.getPassword().equals(admin.getConfirmPassword())) {
			return adminrepository.save(admin);
	
	}else {
		return null;
	}
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		// TODO Auto-generated method stub
		 Admin admin = adminrepository.findByEmail(email);
		 if (admin != null && passwordMatches(admin, password)) {
	           return admin;
	        } else 
	        {
	         
	            return null;
	        }
	    }
    private boolean passwordMatches(Admin admin, String providedPassword) {
		// TODO Auto-generated method stub
    	 return admin.getPassword().equals(providedPassword);
	}
	}

	




