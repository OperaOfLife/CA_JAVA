package sg.edu.iss.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.CourseLecturer;

public interface CourseLecturerRepository extends JpaRepository<CourseLecturer, Integer> {

	@Query("SELECT cl FROM CourseLecturer cl INNER JOIN cl.courses c INNER JOIN cl.lecturer l WHERE l.email LIKE :email")
	public ArrayList<CourseLecturer> listCourseNamesByLecturerEmail (@Param("email") String email);
	
}
