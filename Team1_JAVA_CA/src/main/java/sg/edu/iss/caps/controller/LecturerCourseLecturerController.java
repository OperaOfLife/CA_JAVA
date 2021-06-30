package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

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
	public String showHome(@ModelAttribute("courses") Course courses, Model model, HttpSession session)
	{
		UserSession usession = (UserSession) session.getAttribute("usession");
		String currentusername=usession.getUser().getUsername();
		model.addAttribute("ldata", lservice.listCourseNamesByLecturerEmail(currentusername));
		return "view-courses-taught";
	}
}
