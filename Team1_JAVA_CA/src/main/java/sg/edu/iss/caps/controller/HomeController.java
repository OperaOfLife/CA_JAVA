package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class HomeController {
	
	
	@GetMapping("/home")
	public String showHome(Model model)
	{
		return "home";
	}
	
	@GetMapping("/admin")
	public String showAdmin(Model model)
	{
		return "home-admin";
	}
	
	@GetMapping("/student")
	public String showStudent(Model model)
	{
		return "home-student";
	}
	@GetMapping("/lecturer")
	public String showLecturer(Model model)
	{
		return "home-lecturer";
	}
	
	@GetMapping("/about")
	public String showAbout(Model model)
	{
		return "about-us";
	}
	@GetMapping("/courses")
	public String showCourses(Model model)
	{
		return "all-courses";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model)
	{
		return "register";
	}
	

}
