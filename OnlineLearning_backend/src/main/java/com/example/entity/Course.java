package com.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="coursetables")
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseid;

	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "stdid", nullable = false)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Student student;
	 
	@NotEmpty
	@Column(name="course_name")
    private String name;
	
	@NotEmpty
	@Column(name="course_description")
    private String description;
	
public Course() {
		super();
	}
	
  public Course(long courseid, Student student, @NotEmpty String name, @NotEmpty String description) {
		super();
		this.courseid = courseid;
		this.student = student;
		this.name = name;
		this.description = description;
	}
   public long getCourseid() {
		return courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", student=" + student + ", name=" + name + ", description="
				+ description + "]";
	}
	

	

    
	

   
  
	



	
}