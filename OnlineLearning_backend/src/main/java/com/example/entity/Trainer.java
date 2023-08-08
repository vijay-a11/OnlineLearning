
package com.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="trainertable")
public class Trainer {
	@Id
	@GeneratedValue(generator="trainer_seq")
	@SequenceGenerator(name="trainer_seq",sequenceName="trainer_seq",allocationSize=1,initialValue=100)
	private long trainerid;
	
	@NotEmpty
	@Column(name="trainerName")
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
	@Column(name="mobile_numbers")
	private String mobileNo;
	
	public Trainer() {
		super();
	}
	public Trainer(long trainerid, @NotEmpty String userName,
		@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String password,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String confirmPassword,
			@NotEmpty String email, @NotEmpty String mobileNo) {
		super();
		this.trainerid = trainerid;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.mobileNo = mobileNo;
	}



	public long getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(long trainerid) {
		this.trainerid = trainerid;
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
		return "Trainer [trainerid=" + trainerid + ", userName=" + userName + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	

}
