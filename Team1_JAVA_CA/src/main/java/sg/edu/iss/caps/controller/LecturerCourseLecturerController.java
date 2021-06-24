package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;

@Controller
@RequestMapping("/courselecturer")
public class LecturerCourseLecturerController
{
	@RequestMapping("/home")
	public String showHome(@ModelAttribute("courses") Course courses,Model model)
	{
		return "view-courses-taught";
	}
}
