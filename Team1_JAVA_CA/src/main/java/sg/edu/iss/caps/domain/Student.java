package sg.edu.iss.caps.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private Date admissionDate;
	private String email;
	private String category;
	
	
	
	
	public Student() {
		super();
	}




	public Student(String studentId, String firstName, String middleName, String lastName, Date admissionDate,
			String email, String category) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.admissionDate = admissionDate;
		this.email = email;
		this.category = category;
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




	public Date getAdmissionDate() {
		return admissionDate;
	}




	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", admissionDate=" + admissionDate + ", email=" + email + ", category="
				+ category + "]";
	}
	
	
	
	

}
