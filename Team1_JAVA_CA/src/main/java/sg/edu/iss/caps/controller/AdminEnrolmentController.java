package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;


@Controller
@RequestMapping("/adminenrolment")
public class AdminEnrolmentController
{
	
	@RequestMapping("/list")
	public String showHome(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		return "manage-enrolments";
	}
	
	
	

}
