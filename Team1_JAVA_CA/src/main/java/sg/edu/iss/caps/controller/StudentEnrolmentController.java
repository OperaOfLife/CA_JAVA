package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;

@Controller
@RequestMapping("/studentEnrolment")
public class StudentEnrolmentController 
{

	@RequestMapping("/coursesForEnrolment")
	public String showCoursesForEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		return "view-courses";
	}
	
	@RequestMapping("/enrolledCourses")
	public String showEnrolledCourses(@ModelAttribute("courses") Course courses,Model model)
	{
		return "enrolled-courses";
	}
}
