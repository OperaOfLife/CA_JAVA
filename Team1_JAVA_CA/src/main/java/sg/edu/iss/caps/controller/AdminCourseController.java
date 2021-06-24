package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;

@Controller
@RequestMapping("/admincourse")
public class AdminCourseController 
{
			@RequestMapping("/list")
			public String showHome(@ModelAttribute("courses") Course courses,Model model)
			{
				return "manage-courses";
			}
			
}
