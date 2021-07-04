package sg.edu.iss.caps.repo;



import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;

public interface CourseLecturerRepository extends JpaRepository<CourseLecturer, Integer>
{


	//Find Course Name by Linking up Course Ids and searching LecturerId
	
	@Query("SELECT c FROM CourseLecturer cl INNER JOIN cl.courses c INNER JOIN cl.lecturer l WHERE l.lecturerId LIKE :lecturerid")
	public ArrayList<Course> listCoursesByLecturerId (@Param("lecturerid") String id);

	
	  @Query("SELECT DISTINCT cl FROM CourseLecturer cl INNER JOIN  cl.lecturer l  WHERE  l.email LIKE :email" ) 
	  public ArrayList<CourseLecturer> listCourseNamesByLecturerEmail  (@Param("email") String email);
	 
		
		
		  @Query("SELECT cl FROM CourseLecturer cl WHERE cl.lecturer.firstName LIKE :firstname AND cl.courses.courseName LIKE :coursename") 
		  public CourseLecturer findCourseByCourseAndLecturerName(@Param("firstname") String firstname, @Param("coursename") String coursename);
		 
	  
	  
		/*
		 * @Query("SELECT l.lecturerId FROM CourseLecturer cl INNER JOIN cl.lecturer l WHERE l.lecturerId LIKE :lecturerid"
		 * ) public String findLecturerIdByLecturerId(@Param("lecturerid")String id);
		 * 
		 * 
		 * @Query("SELECT c.courseId FROM CourseLEcturer cl INNER JOIN cl.courses c WHERE c.courseId LIKE:courseid"
		 * ) public String findCourseIdByCourseId(@Param("courseid") String id);
		 */
}
