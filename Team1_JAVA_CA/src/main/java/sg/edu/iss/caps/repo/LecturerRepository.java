package sg.edu.iss.caps.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String> 
{


	@Query("SELECT l FROM Lecturer l WHERE l.email LIKE :email")
	public Lecturer findLecturerByEmail(@Param("email") String email);


	//Find lectuerId from user email
	@Query("SELECT l.lecturerId FROM Lecturer l WHERE l.email LIKE :email")
	public String findLecturerIdbyEmail(@Param("email") String email); 

}
