package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.User;
import sg.edu.iss.caps.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	LoginRepository urepo;

	@Override
	public void createUser(User user) 
	{
		urepo.save(user);
	}

	
	
	@Override
	public boolean authenticate(User user)
	{
		User fromDB = urepo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (fromDB != null)
			return true;
		else
			return false;
	}

	@Override
	public User findByName(String name) 
	{
		return urepo.findUserByUsername(name);
	}
	@Override
	public RoleType findRoleByName(String name) 
	{
		return urepo.findRoleByUsername(name);
	}
}
