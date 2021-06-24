package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;

@Controller
@RequestMapping("/studentGrades")
public class StudentGradesGPAController 
{

	
	@RequestMapping("/gradesGPA")
	public String gradesGPA(@ModelAttribute("courses") Course courses,Model model)
	{
		return "grades-gpa";
	}
	
}
