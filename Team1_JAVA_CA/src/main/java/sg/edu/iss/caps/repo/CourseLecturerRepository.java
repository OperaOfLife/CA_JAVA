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
	 
	  @Query("SELECT cl FROM CourseLecturer cl WHERE cl.lecturer.lecturerId LIKE :lecturerid AND cl.courses.courseId LIKE :courseid") 
	  public CourseLecturer findCourseByCourseAndLecturerId(@Param("lecturerid") String lecturerid, @Param("courseid") String courseid);
	
	/*
	 * @Query("SELECT DISTINCT cl FROM CourseLecturer cl INNER JOIN  cl.courses c INNER JOIN  cl.lecturer l INNER JOIN c.enrolment e  WHERE e.status <> '1' AND  l.email LIKE :email"
	 * ) public ArrayList<CourseLecturer> listCourseNamesByLecturerEmail
	 * (@Param("email") String email);
	 */
}
