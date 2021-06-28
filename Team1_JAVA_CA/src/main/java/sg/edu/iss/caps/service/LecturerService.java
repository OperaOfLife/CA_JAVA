package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;

public interface LecturerService {

	public Course findCourseById(String id);
	public String findLecturerIdbyEmail(String email);
	public ArrayList<Course> listAllcourses();
	public ArrayList<Course> findCoursesByLecturerId(String id);
	public ArrayList<Enrolment>listEnrolmentByCourseId(String id);
	public Enrolment listEnrolmentByEnrolmentId(int id);
	public void saveUpdatedGrades(Enrolment enrolment);
}
