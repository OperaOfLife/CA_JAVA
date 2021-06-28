package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;


@Controller
@RequestMapping("/main")
public class HomeController
{

	@Autowired
	CourseRepository crepo;
	
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
			List<Course> courses = (List<Course>) crepo.findAll();
			model.addAttribute("courses", courses);
			
		
		return "all-courses";
	}
	
	
	
	@GetMapping("/contact-us")
	public String showContactUs(Model model)
	{
		return "contact-us";
	}

}
