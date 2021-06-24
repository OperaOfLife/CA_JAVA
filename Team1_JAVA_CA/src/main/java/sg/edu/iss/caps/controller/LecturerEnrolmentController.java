package sg.edu.iss.caps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;

@Controller
@RequestMapping("/lecturerenrolment")
public class LecturerEnrolmentController 
{
	@RequestMapping("/home")
	public String showEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		return "view-course-enrolment";
	}
	
	@RequestMapping("/gradecourse")
	public String gradeCourse(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		return "grade-course";
	}
	
	@RequestMapping("/performance")
	public String performance(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		return "view-student-performance";
	}
	
}
