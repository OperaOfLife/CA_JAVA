package sg.edu.iss.caps.service;

import java.util.ArrayList;
import java.util.List;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;

public interface LecturerService {

	public Course findCourseById(String id);
	public String findLecturerbyEmail(String email);
	public ArrayList<Course> listAllcourses();

	//public Course findCourseById(String courseId);
	public Object listEnrolmentByCourseId(int courseId);
	public String findLecturerIdbyEmail(String string);
	public Object findCourseNamesByLecturerId(int lecturerId);

	

	public ArrayList<Course> findCoursesByLecturerId(String id);
	public ArrayList<Enrolment>listEnrolmentByCourseId(String id);
	public Enrolment listEnrolmentByEnrolmentId(int id);
	public void saveUpdatedGrades(Enrolment enrolment);


	public ArrayList<CourseLecturer> listCourseNamesByLecturerEmail (String lectureremail);
	
	//Genesis Student Performace
	public List<Enrolment> listAll(String keyword);

}
