package sg.edu.iss.caps.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.User;

public interface LoginRepository extends JpaRepository<User, Integer>
{

	public User findUserByUsernameAndPassword(String un, String pwd);
    public User findUserByUsername(String name);
    public RoleType findRoleByUsername(String name);
}
