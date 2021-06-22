package sg.edu.iss.caps.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.User;

public interface LoginRepository extends JpaRepository<User, Integer>{

}
