package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="studenttable")
public class Student {
	@Id
	@GeneratedValue(generator="stud_seq")
	@SequenceGenerator(name="stud_seq",sequenceName="stud_seq",allocationSize=1,initialValue=2000)
    private long stdid;
	
	
	@NotEmpty
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@NotEmpty
	@Column(name="UserName")
	private String userName;
	
	@NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(name="Password")
	private String password;
	
	@NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,}")
	@Column(name="ConfirmPassword")
	private String confirmPassword;
	
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Column(name="mobile_number")
	private String mobileNo;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore // Exclude from serialization to avoid infinite loop
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Course> course;

	public Student() {
		super();
	}
	public Student(long stdid, @NotEmpty String firstName, String lastName, @NotEmpty String userName,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String password,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,}") String confirmPassword,
			@NotEmpty String email, @NotEmpty String mobileNo, List<Course> course) {
		super();
		this.stdid = stdid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.mobileNo = mobileNo;
		this.course = course;
	}

  public long getStdid() {
		return stdid;
	}

	public void setStdid(long stdid) {
		this.stdid = stdid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", confirmPassword=" + confirmPassword + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", course=" + course + "]";
	}
	

	

	

}
