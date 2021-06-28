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
}
