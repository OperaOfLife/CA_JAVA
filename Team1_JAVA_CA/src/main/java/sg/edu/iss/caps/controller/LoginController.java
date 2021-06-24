package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.User;
import sg.edu.iss.caps.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	
	
	@Autowired
	LoginService lservice;
	
	@RequestMapping("/home")
	public String showHome(@ModelAttribute("user") User user,Model model)
	{
		return "login";
	}
	
	
	@Autowired
	public void setUserInterface(LoginService ls) {
		this.lservice = ls;
	}
	
	@RequestMapping(path = "/login")
	public String login(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
	
	@RequestMapping(path = "/authenticate")
	public String authenticate(@ModelAttribute("user") User user, Model model, HttpSession session) 
	{
		if(lservice.authenticate(user)) 
		{
			User u = lservice.findByName(user.getUsername());
			session.setAttribute("usession", u);
			return "register";
		}
		else
			return "login";
	}
	
}
