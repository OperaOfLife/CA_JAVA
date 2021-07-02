package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;



@Controller
@RequestMapping("/admincourse")
public class AdminCourseController 
{
	@Autowired
	CourseRepository crepo;
	
	
	@RequestMapping("/add")
	public String showCourseForm(Model model)
	{
		Course course = new Course();
		model.addAttribute("course", course);
		return "add-courses";
	}
	
	@RequestMapping("/save")
	public String saveCourseForm(@ModelAttribute("course") Course course, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors())
		{
			return "add-courses";
		}
		crepo.save(course);
		return "forward:/admincourse/list";
	}
	
	@RequestMapping("/list")
	public String listCourses(Model model) {
		List<Course> courses = (List<Course>) crepo.findAll();
		model.addAttribute("courses", courses);
		
		return "manage-courses";
	}
	
	@RequestMapping("/edit/{courseId}")
	public String showEditForm(Model model, @PathVariable("courseId") String courseId) {
		model.addAttribute("course", crepo.findById(courseId).get());
		
		return "add-courses";
	}
	
	@RequestMapping("/delete/{courseId}")
	public String deleteMethod(Model model, @PathVariable("courseId") String courseId) {
		Course course = crepo.findById(courseId).get();
		crepo.delete(course);
		return "forward:/admincourse/list";
	}
			
}
