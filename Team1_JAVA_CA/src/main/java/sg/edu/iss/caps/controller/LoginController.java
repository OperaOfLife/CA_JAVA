package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.User;
import sg.edu.iss.caps.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	
	
	@Autowired
	LoginService lservice;
	
	
	
	@Autowired
	public void setUserInterface(LoginService ls) {
		this.lservice = ls;
	}
	
	@RequestMapping(path = "/home")
	public String login(Model model) 
	{
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
	
	@RequestMapping(path = "/register")
	public String register(Model model) 
	{
		User u = new User();
		model.addAttribute("newuser", u);
		
		return "register";
	}
	
	@RequestMapping(path = "/authenticateRegister")
	public String authenticate(@ModelAttribute("newuser") User user, Model model) 
	{
		
		
		if(! lservice.authenticate(user)) 
		{
			user.setRole(RoleType.LECTURER);
			lservice.createUser(user);
			return "home";
		}
		else
			return "register";
	}
	
	
	
	@RequestMapping(path = "/exit")
	public String logout(@ModelAttribute("user") User user, Model model, HttpSession session) 
	{
		session.setAttribute("usession", null);
		return "home";
	}
	
	
	
	@RequestMapping(path = "/authenticate")
	public String register(@ModelAttribute("user") User user, Model model, HttpSession session) 
	{
		if(lservice.authenticate(user)) 
		{
			User u = lservice.findByName(user.getUsername());
			session.setAttribute("usession", u);	
			
			if(u.getRole().equals(RoleType.ADMIN)) 
				  return "home-admin";			  
			else if(u.getRole().equals(RoleType.LECTURER))
			 			    return "home-lecturer";
			else if(u.getRole().equals(RoleType.STUDENT))
	 			    return "home-student";
			  else
				  return "register";
		}
		else
			return "login";
	}
	
	
}
