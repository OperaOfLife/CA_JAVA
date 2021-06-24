package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;

@Controller
@RequestMapping("/adminlecturer")
public class AdminLecturerController 
{

		@RequestMapping("/list")
		public String showHome(@ModelAttribute("lecturer") Lecturer lecturer,Model model)
		{
			return "manage-lecturers";
		}
		@RequestMapping("/create")
		public String createStudent(@ModelAttribute("student") Student student,Model model)
		{
			return "add-lecturers";
		}
		
}
