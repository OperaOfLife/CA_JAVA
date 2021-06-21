package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Enrolment;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

}
