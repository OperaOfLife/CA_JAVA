package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> 
{

	//Find lectuerId from user email
	@Query("SELECT l.lecturerId FROM Lecturer l WHERE l.email LIKE :email")
	public String findLecturerIdbyEmail(@Param("email") String email); 
}
