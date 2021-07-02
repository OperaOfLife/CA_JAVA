package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;

public interface CourseRepository extends JpaRepository<Course, String>
{

	@Query("SELECT c FROM Course c WHERE c.courseName LIKE :name") 
	 public List<Course> findCoursesByName1(@Param("name") String name);
	Course findByCourseId(String courseId);

	
	
}
