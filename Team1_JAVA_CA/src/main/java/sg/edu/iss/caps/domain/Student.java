package sg.edu.iss.caps.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student
{
	private static final Date NULL = null;
	@Id
	private String studentId;
	private String firstName;
	private String middleName;
	private String lastName;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private Date admissionDate;
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



	public Student(String studentId, String firstName, String middleName, String lastName, Date admissionDate,
			String email) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.admissionDate = admissionDate;
		this.email = email;
	}



	public Student(String studentId, String firstName, String middleName, String lastName, Date admissionDate,
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



	public List<Enrolment> getEnrolment() {
		return enrolment;
	}



	public void setEnrolment(List<Enrolment> enrolment) {
		this.enrolment = enrolment;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", admissionDate=" + admissionDate + ", email=" + email + ", enrolment="
				+ enrolment + "]";
	}



	

}
