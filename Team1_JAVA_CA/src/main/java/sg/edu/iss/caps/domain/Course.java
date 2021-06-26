package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course
{
	@Id
	private String courseId;
	private String courseName;
	private String description;
	private String classSize;
	private int credits;
	private int duration;
	
	@OneToMany(mappedBy="courses")
	private List<CourseLecturer> Courselecturer;
	
	@OneToMany(mappedBy="course")
	private List<Enrolment> enrolment;
	
	public Course() {
		super();
	}
	
	
	

	public Course(String courseId, String courseName, String description, String classSize, int credits, int duration,
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




	public String getClassSize() {
		return classSize;
	}




	public void setClassSize(String classSize) {
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




	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", classSize=" + classSize + ", credits=" + credits + ", duration=" + duration + ", Courselecturer="
				+ Courselecturer + ", enrolment=" + enrolment + "]";
	}


	
	


	

}
