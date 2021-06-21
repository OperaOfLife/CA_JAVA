package sg.edu.iss.caps.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Classes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private Date startDate;
	@ManyToOne
	private Course course;
	
	
	
	public Classes() {
		super();
	}



	public Classes(Date startDate, Course course) {
		super();
		this.startDate = startDate;
		this.course = course;
	}



	public Classes(int classId, Date startDate, Course course) {
		super();
		this.classId = classId;
		this.startDate = startDate;
		this.course = course;
	}



	public int getClassId() {
		return classId;
	}



	public void setClassId(int classId) {
		this.classId = classId;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", startDate=" + startDate + ", course=" + course + "]";
	}

	
}
