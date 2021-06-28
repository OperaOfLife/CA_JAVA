package sg.edu.iss.caps.domain;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Enrolment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrolmentId;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate enrolmentDate;
	private String grade;
	private EnrolmentStatus status;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Course course;
	
	
	
	
	public Enrolment() {
		super();
	}




	public Enrolment(LocalDate enrolmentDate, String grade, EnrolmentStatus status, Student student, Course course) {
		super();
		this.enrolmentDate = enrolmentDate;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.course = course;
	}




	public Enrolment(int enrolmentId, LocalDate enrolmentDate, String grade, EnrolmentStatus status, Student student, Course course) {
		super();
		this.enrolmentId = enrolmentId;
		this.enrolmentDate = enrolmentDate;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.course = course;
	}
	
	


	public Enrolment(LocalDate enrolmentDate, String grade, Student student, Course course) {
		super();
		this.enrolmentDate = enrolmentDate;
		this.grade = grade;
		this.student = student;
		this.course = course;
	}




	public int getEnrolmentId() {
		return enrolmentId;
	}




	public void setEnrolmentId(int enrolmentId) {
		this.enrolmentId = enrolmentId;
	}




	public LocalDate getEnrolmentDate() {
		return enrolmentDate;
	}




	public void setEnrolmentDate(LocalDate enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}




	public EnrolmentStatus getStatus() {
		return status;
	}




	public void setStatus(EnrolmentStatus status) {
		this.status = status;
	}




	public Student getStudent() {
		return student;
	}




	public void setStudent(Student student) {
		this.student = student;
	}




	public Course getCourse() {
		return course;
	}




	public void setCourse(Course course) {
		this.course = course;
	}




	
}
