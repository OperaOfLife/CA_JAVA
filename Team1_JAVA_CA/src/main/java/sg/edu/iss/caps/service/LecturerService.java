package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Course;


public interface LecturerService 
{

	public ArrayList<Course> listAllcourses();
	public Course findCourseById(String courseId);
	public Object listEnrolmentByCourseId(int courseId);
	public int findLecturerIdbyEmail(String string);
	public Object findCourseNamesByLecturerId(int lecturerId);
	
	
}
