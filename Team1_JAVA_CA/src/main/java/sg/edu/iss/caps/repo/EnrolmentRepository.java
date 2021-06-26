package sg.edu.iss.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Enrolment;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

	@Query("SELECT e FROM Enrolment e, Course c WHERE c.courseId LIKE :id")
	public ArrayList<Enrolment>findEnrolmentByCourseId(@Param("id") int id);
}
