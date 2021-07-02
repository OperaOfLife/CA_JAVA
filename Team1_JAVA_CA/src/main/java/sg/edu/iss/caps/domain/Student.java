package sg.edu.iss.caps.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student
{
	
	@Id
	private String studentId;
	private String firstName;
	private String middleName;
	private String lastName;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate admissionDate;
	private String email;
	@OneToMany(mappedBy="student")
	private List<Enrolment> enrolment;
	
	
	
	public Student() {
		super();
	}



	public Student(String studentId, String firstName, String middleName, String lastName, String email) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		
	}



	public Student(String studentId, String firstName, String middleName, String lastName, LocalDate admissionDate,
			String email) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.admissionDate = admissionDate;
		this.email = email;
	}



	public Student(String studentId, String firstName, String middleName, String lastName, LocalDate admissionDate,
			String email, List<Enrolment> enrolment) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.admissionDate = admissionDate;
		this.email = email;
		this.enrolment = enrolment;
	}



	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public LocalDate getAdmissionDate() {
		return admissionDate;
	}



	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Enrolment> getEnrolment() {
		return enrolment;
	}



	public void setEnrolment(List<Enrolment> enrolment) {
		this.enrolment = enrolment;
	}



	

}
