package sg.edu.iss.caps.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerService {

	public Course findCourseById(String id);
	public String findLecturerbyEmail(String email);
	public ArrayList<Course> listAllcourses();

	//public Course findCourseById(String courseId);
	public Object listEnrolmentByCourseId(int courseId);
	public String findLecturerIdbyEmail(String string);
	public Object findCourseNamesByLecturerId(int lecturerId);

	 //Gen add for grade a course 
	 public Optional<Enrolment> findByEnrolmentId(int id);

	public ArrayList<Course> findCoursesByLecturerId(String id);
	public ArrayList<Enrolment>listEnrolmentByCourseId(String id);
	public Enrolment listEnrolmentByEnrolmentId(int id);
	public void saveUpdatedGrades(Enrolment enrolment);
	public Lecturer findLecturerById(String id);
	public Course findCourseByName(String name);
	public String findLecturerNamebyEmail(String email);
	public List<CourseLecturer> listCourseNamesByLecturerEmail (String lectureremail);
	public CourseLecturer findCourseByCourseAndLecturerId(String lecturerid,String courseid);
	//Genesis Student Performace
	public List<Enrolment> listAll(String keyword);
	public ArrayList<String> findAllCourseName();
	public ArrayList<String> findAllLecturerNames();
	
	public Lecturer findLecturerByName(String name);
	public void addCousesTaught(CourseLecturer courselecturer);
	
	

}
