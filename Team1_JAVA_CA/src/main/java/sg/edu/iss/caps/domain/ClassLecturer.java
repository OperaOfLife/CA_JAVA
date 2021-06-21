package sg.edu.iss.caps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassLecturer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Classes classes;
	@ManyToOne
	private Lecturer lecturer;
	
	
	
	public ClassLecturer() {
		super();
	}



	public ClassLecturer(Classes classes, Lecturer lecturer) {
		super();
		this.classes = classes;
		this.lecturer = lecturer;
	}



	public ClassLecturer(int id, Classes classes, Lecturer lecturer) {
		super();
		this.id = id;
		this.classes = classes;
		this.lecturer = lecturer;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Classes getClasses() {
		return classes;
	}



	public void setClasses(Classes classes) {
		this.classes = classes;
	}



	public Lecturer getLecturer() {
		return lecturer;
	}



	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}



	@Override
	public String toString() {
		return "ClassLecturer [id=" + id + ", classes=" + classes + ", lecturer=" + lecturer + "]";
	}
	
	
}
