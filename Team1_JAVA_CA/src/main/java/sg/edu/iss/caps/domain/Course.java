package sg.edu.iss.caps.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course
{
	@Id
	private String courseId;
	private String courseName;
	private String description;
	private int classSize;
	private int credits;
	private int duration;
	
	/*
	 * @DateTimeFormat(pattern="dd-MM-yyyy") private LocalDate courseStartDate;
	 */
	
	@OneToMany(mappedBy="courses")
	private List<CourseLecturer> Courselecturer;
	
	@OneToMany(mappedBy="course")
	private List<Enrolment> enrolment;
	
	public Course() {
		super();
	}
	
	


	public Course(String courseId, String courseName, String description, int classSize, int credits, int duration,
			 List<CourseLecturer> courselecturer, List<Enrolment> enrolment) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.classSize = classSize;
		this.credits = credits;
		this.duration = duration;
		
		Courselecturer = courselecturer;
		this.enrolment = enrolment;
	}

	
	

	public Course(String courseId, String courseName, String description, int classSize, int credits, int duration,
			LocalDate courseStartDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.classSize = classSize;
		this.credits = credits;
		this.duration = duration;
		}




	public String getCourseId() {
		return courseId;
	}




	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}




	public String getCourseName() {
		return courseName;
	}




	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getClassSize() {
		return classSize;
	}




	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}




	public int getCredits() {
		return credits;
	}




	public void setCredits(int credits) {
		this.credits = credits;
	}




	public int getDuration() {
		return duration;
	}




	public void setDuration(int duration) {
		this.duration = duration;
	}




	




	public List<CourseLecturer> getCourselecturer() {
		return Courselecturer;
	}




	public void setCourselecturer(List<CourseLecturer> courselecturer) {
		Courselecturer = courselecturer;
	}




	public List<Enrolment> getEnrolment() {
		return enrolment;
	}




	public void setEnrolment(List<Enrolment> enrolment) {
		this.enrolment = enrolment;
	}




	




}
