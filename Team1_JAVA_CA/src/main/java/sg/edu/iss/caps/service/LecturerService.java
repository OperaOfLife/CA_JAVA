package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;

public interface LecturerService {

	public Course findCourseById(int id);
	public int findLecturerIdbyEmail(String email);
	public ArrayList<Course> listAllcourses();
	public ArrayList<Course> findCoursesByLecturerId(int id);
	public ArrayList<Enrolment>listEnrolmentByCourseId(int id);
	public Enrolment listEnrolmentByEnrolmentId(int id);
	public void saveUpdatedGrades(Enrolment enrolment);
}
