package sg.edu.iss.caps.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String>
{
	@Query("SELECT s FROM  Student s WHERE s.email LIKE :email")
	public Student findStudentIdByEmail(@Param("email") String email);
	
	@Query("SELECT s FROM  Student s WHERE s.firstName LIKE :firstname")
	public Student findStudentByName(@Param("firstname") String firstname);
	
	
}
