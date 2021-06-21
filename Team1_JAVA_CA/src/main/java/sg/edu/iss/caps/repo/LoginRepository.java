package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
