package sg.edu.iss.caps.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.service.HomeService;


@Controller
@RequestMapping("/main")
public class HomeController
{

	@Autowired
	CourseRepository crepo;
	@Autowired
	HomeService hs;
	
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
	
	@GetMapping("/paging")
	public String viewHomePage(Model model) {
		return findPaginated(1, "courseName", "asc", model);		
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 2;
		
		Page<Course> page = hs.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Course> listcourses = page.getContent();
		//List<Course> allcourses = crepo.findAll();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listcourses", listcourses);
		return "all-courses";
	}
}
