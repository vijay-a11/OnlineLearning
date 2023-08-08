package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="admintable")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long adminid;
	
	@NotEmpty
	@Column(name="User_Name")
    private String userName;
	
    @NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(name="Password")
	private String password;
    
    @NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(name="ConfirmPassword")
    private String confirmPassword;
    
    @NotEmpty
	@Column(name="email")
    private String email;
    
    @NotEmpty
	@Column(name="mobile_number")
    private String mobileNo;
	
	
	
	public Admin() {
		super();
	}
	
    public Admin(long adminid, @NotEmpty String userName,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String password,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String confirmPassword,
			@NotEmpty String email, @NotEmpty String mobileNo) {
		super();
		this.adminid = adminid;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.mobileNo = mobileNo;
	}

   public long getAdminid() {
		return adminid;
	}



	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", userName=" + userName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	

}