package sg.edu.iss.caps.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Enrolment;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

	@Query("SELECT e FROM Enrolment e INNER JOIN e.course c WHERE c.courseId LIKE :id")
	public ArrayList<Enrolment>findEnrolmentByCourseId(@Param("id") String id);


	/*
	 * @Query("SELECT e FROM Enrolment e, Student s WHERE s.studentId LIKE :id")
	 * public ArrayList<Enrolment>findEnrolmentByStudentId(@Param("id") String id);
	 */
	 @Query("SELECT e FROM Enrolment e INNER JOIN e.student s WHERE s.studentId LIKE :id")
	 public ArrayList<Enrolment>findEnrolmentByStudentId(@Param("id") String id);


	//list courses that a particular student is enrolled in using student email to search
	@Query("SELECT e FROM Enrolment e INNER JOIN e.course c INNER JOIN e.student s WHERE s.email LIKE :email")
	public ArrayList<Enrolment> listCoursesEnrolledByStudentEmail (@Param("email") String email);

	//Genesis Student Performance
	@Query("SELECT e FROM Enrolment e INNER JOIN e.student s INNER JOIN e.course c "
			+ "WHERE CONCAT(s.studentId, ' ', s.firstName, ' ', s.middleName, ' ', s.lastName)"
			+ "LIKE %?1%")
	public List<Enrolment> search(String keyword);
}
