package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.User;

public interface LoginService
{
	public void createUser(User user);
	public void updateUser(User user);
	public List<User> listAllUser();
	public void deleteUser(User user);
	public boolean authenticate(User user);
	public User findByName(String name);
}
