package sg.edu.iss.caps.domain;

import java.util.Date;

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
	private Date enrolmentDate;
	private String grade;
	private String status;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Classes classes;
	
	
	
	
	public Enrolment() {
		super();
	}




	public Enrolment(Date enrolmentDate, String grade, String status, Student student, Classes classes) {
		super();
		this.enrolmentDate = enrolmentDate;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.classes = classes;
	}




	public Enrolment(int enrolmentId, Date enrolmentDate, String grade, String status, Student student,
			Classes classes) {
		super();
		this.enrolmentId = enrolmentId;
		this.enrolmentDate = enrolmentDate;
		this.grade = grade;
		this.status = status;
		this.student = student;
		this.classes = classes;
	}




	public int getEnrolmentId() {
		return enrolmentId;
	}




	public void setEnrolmentId(int enrolmentId) {
		this.enrolmentId = enrolmentId;
	}




	public Date getEnrolmentDate() {
		return enrolmentDate;
	}




	public void setEnrolmentDate(Date enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Student getStudent() {
		return student;
	}




	public void setStudent(Student student) {
		this.student = student;
	}




	public Classes getClasses() {
		return classes;
	}




	public void setClasses(Classes classes) {
		this.classes = classes;
	}




	@Override
	public String toString() {
		return "Enrolment [enrolmentId=" + enrolmentId + ", enrolmentDate=" + enrolmentDate + ", grade=" + grade
				+ ", status=" + status + ", student=" + student + ", classes=" + classes + "]";
	}
	
	
	


}
