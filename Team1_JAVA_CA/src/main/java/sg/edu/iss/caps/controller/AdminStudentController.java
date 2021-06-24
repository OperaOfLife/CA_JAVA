package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Student;

@Controller
@RequestMapping("/adminstudent")
public class AdminStudentController 
{

	@RequestMapping("/list")
	public String showHome(@ModelAttribute("student") Student student,Model model)
	{
		return "manage-students";
	}
	
	@RequestMapping("/create")
	public String createStudent(@ModelAttribute("student") Student student,Model model)
	{
		return "add-students";
	}
	
	
}
