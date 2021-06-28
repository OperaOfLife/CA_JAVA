package sg.edu.iss.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Student;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

	@Query("SELECT e FROM Enrolment e INNER JOIN e.course c WHERE c.courseId LIKE :id")
	public ArrayList<Enrolment>findEnrolmentByCourseId(@Param("id") String id);

	/*
	 * @Query("SELECT e FROM Enrolment e, Student s WHERE s.studentId LIKE :id")
	 * public ArrayList<Enrolment>findEnrolmentByStudentId(@Param("id") String id);
	 */
	 @Query("SELECT e FROM Enrolment e INNER JOIN e.student s WHERE s.studentId LIKE :id")
	 public ArrayList<Enrolment>findEnrolmentByStudentId(@Param("id") String id);

}
