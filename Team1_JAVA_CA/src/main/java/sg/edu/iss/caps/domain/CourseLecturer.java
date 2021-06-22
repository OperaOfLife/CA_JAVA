package sg.edu.iss.caps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseLecturer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Course courses;
	@ManyToOne
	private Lecturer lecturer;
	
	
	
	public CourseLecturer() {
		super();
	}
	public CourseLecturer(Course courses, Lecturer lecturer) {
		super();
		this.courses = courses;
		this.lecturer = lecturer;
	}
	public CourseLecturer(int id, Course courses, Lecturer lecturer) {
		super();
		this.id = id;
		this.courses = courses;
		this.lecturer = lecturer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	@Override
	public String toString() {
		return "CourseLecturer [id=" + id + ", courses=" + courses + ", lecturer=" + lecturer + "]";
	}
	
}
