package sg.edu.iss.caps.controller;

import java.security.Principal;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.domain.User;
import sg.edu.iss.caps.service.LecturerService;
import sg.edu.iss.caps.service.LoginService;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	
	
	@Autowired
	LoginService lservice;
	
	String errmsg="";
	String msg="NO SUCH EMAIL ID EXISTS.";
	String msg1="USER ALREADY EXISTS.";

	/*
	 * private Object SecurityContextHolder;
	 * 
	 * 
	 * Authentication auth = ((Object)
	 * SecurityContextHolder).getContext().getAuthentication(); String username =
	 * auth.getUsername();
	 * 
	 */
	
	/*
	 * @RequestMapping(value = "/myusername", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String currentUserName(Principal principal) {
	 * p=principal.getName(); return principal.; }
	 */
	  
	/*
	 * @RequestMapping(value = "/myusername", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String getUsername(HttpServletRequest req) { return
	 * req.getUserPrincipal.getName(); }
	 */
	 
	  @RequestMapping("/user")
	  public void user(Authentication authentication)
	  {
	        String properties =  authentication.getUsername();
	        //String loginProperty = properties.get("login");
	        //Do what you want to do with your property
	    }
	
	
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
		
		
		if(! lservice.authenticateRegister(user)) 
		{
			Student s=lservice.studentByEmail(user.getUsername());
			Lecturer l=lservice.lecturerByEmail(user.getUsername());
			if(s!=null)
			   user.setRole(RoleType.STUDENT);
			else if(l!=null)
					user.setRole(RoleType.LECTURER);
			else
			{
				model.addAttribute("errmsg",msg );
				return "register";
			}
			lservice.createUser(user);
			return "home";
		}
		else
		{
			model.addAttribute("errmsg",msg1 );
			return "register";
		}
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
			  {
				  model.addAttribute("errmsg",msg );
				 return "register";
			  }
		}
		else
			return "login";
	}
	
	
}
