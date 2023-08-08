package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Assignmenttable")
public class Assignment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assignmentid;
	
	@NotEmpty
	@Column(name="assignment_title")
    private String title;
	
	@Column(name="assignment_duedate")
	@Temporal(TemporalType.DATE)
	private Date duedate;
	
	
	
	public Assignment() {
		super();
	}
   public Assignment(long assignmentid, @NotEmpty String title,Date duedate) {
		super();
		this.assignmentid = assignmentid;
		this.title = title;
		this.duedate =duedate ;
	}
 public long getAssignmentid() {
	return assignmentid;
}
public void setAssignmentid(long assignmentid) {
	this.assignmentid = assignmentid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getDuedate() {
	return duedate;
}
public void setDuedate(Date duedate) {
	this.duedate = duedate;
}
@Override
public String toString() {
	return "Assignment [assignmentid=" + assignmentid + ", title=" + title + ", duedate=" + duedate + "]";
}

   
	
  

}

	