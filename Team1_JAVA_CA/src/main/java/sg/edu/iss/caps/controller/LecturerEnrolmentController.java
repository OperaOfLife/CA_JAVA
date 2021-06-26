package sg.edu.iss.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.service.CourseService;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/lecturerenrolment")
public class LecturerEnrolmentController 
{
	@Autowired
	CourseService cservice;
	
	@Autowired
	StudentService sservice;
	
	//Display All Courses
	@RequestMapping("/home")
	public String showEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		model.addAttribute("allcourses", cservice.listAllcourses());
		return "view-course-enrolment";
	}
	
	//Display Selected Course and its enrolment 
	@RequestMapping("/coursedetail/{courseId}")
	public String enrolmentDetails(@PathVariable("courseId") int courseId, Model model) {
		model.addAttribute("course", cservice.findCourseById(courseId));
		model.addAttribute("enrolments", sservice.listEnrolmentByCourseId(courseId));
		return "view-course-enrolment-details";
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
