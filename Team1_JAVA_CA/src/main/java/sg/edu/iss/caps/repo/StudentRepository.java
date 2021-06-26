package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
