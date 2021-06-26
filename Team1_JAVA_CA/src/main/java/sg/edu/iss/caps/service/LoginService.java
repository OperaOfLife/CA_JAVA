package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.User;

public interface LoginService
{
	
	public User findByName(String name);
	public void createUser(User user);
	public boolean authenticate(User user);
	public RoleType findRoleByName(String name);
	
}
