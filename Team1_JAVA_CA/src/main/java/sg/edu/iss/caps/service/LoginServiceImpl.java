package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.domain.User;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.LoginRepository;
import sg.edu.iss.caps.repo.StudentRepository;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	LoginRepository urepo;
	
	@Autowired
	LecturerRepository lrepo;
	
	@Autowired
	StudentRepository srepo;
	
	

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
	public boolean authenticateRegister(User user)
	{
		User fromDB = urepo.findUserByUsername(user.getUsername());
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



	@Override
	public Lecturer lecturerByEmail(String email) 
	{
		
		return lrepo.findLecturerByEmail(email);
	}



	@Override
	public Student studentByEmail(String email) {
		
		return srepo.findStudentIdByEmail(email);
	}



	
}
