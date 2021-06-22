package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Lecturer 
{
	
	@Id
	private String lecturerId;
	private String firstName;
	private String middleName;
	private String lastName;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private String dateOfJoining;
	private String email;
	
	@OneToMany(mappedBy="lecturer")
	private List<CourseLecturer> courselecturer;
	
	
	
	
	
	public Lecturer() {
		super();
	}





	public Lecturer(String lecturerId, String firstName, String middleName, String lastName, String dateOfJoining,
			String email, List<CourseLecturer> courselecturer) {
		super();
		this.lecturerId = lecturerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.courselecturer = courselecturer;
	}





	public String getLecturerId() {
		return lecturerId;
	}





	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
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





	public String getDateOfJoining() {
		return dateOfJoining;
	}





	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public List<CourseLecturer> getCourselecturer() {
		return courselecturer;
	}





	public void setCourselecturer(List<CourseLecturer> courselecturer) {
		this.courselecturer = courselecturer;
	}





	@Override
	public String toString() {
		return "Lecturer [lecturerId=" + lecturerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", dateOfJoining=" + dateOfJoining + ", email=" + email
				+ ", courselecturer=" + courselecturer + "]";
	}




	

}
