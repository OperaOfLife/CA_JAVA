package sg.edu.iss.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.service.LecturerService;

@Controller
@RequestMapping("/courselecturer")
public class LecturerCourseLecturerController
{
	
	@Autowired
	LecturerService lservice;
	
	@RequestMapping("/home")
	public String showHome(@ModelAttribute("courses") Course courses, Model model)
	{
		//hard-code email address here to test first
		model.addAttribute("ldata", lservice.listCourseNamesByLecturerEmail("tin@gmail.com"));
		return "view-courses-taught";
	}
}
