package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;
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
		List<CourseLecturer> course =lservice.listCourseNamesByLecturerEmail(currentusername);
		model.addAttribute("ldata", course);
		ArrayList<Integer>  count=new ArrayList<>();
		
		for(CourseLecturer cl:course)
		{
			List<Enrolment>  enrol =cl.getCourses().getEnrolment();
		
			count.add(enrol.size());
		}
		
		model.addAttribute("count",count);
		
		return "view-courses-taught";
	}
}
