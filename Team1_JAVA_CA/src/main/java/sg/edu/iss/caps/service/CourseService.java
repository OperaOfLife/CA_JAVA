package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Course;

public interface CourseService {

	public ArrayList<Course> listAllcourses();
	public Course findCourseById(int id);
}
