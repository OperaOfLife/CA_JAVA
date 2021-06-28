package sg.edu.iss.caps.repo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String> 
{

	@Query("SELECT l FROM Lecturer l WHERE l.email LIKE :email")
	public Lecturer findLecturerByEmail(@Param("email") String email);

}
