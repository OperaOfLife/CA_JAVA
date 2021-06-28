package sg.edu.iss.caps.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
<<<<<<< HEAD
import sg.edu.iss.caps.service.LecturerService;
import sg.edu.iss.caps.service.StudentService;
=======
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.LecturerService;
>>>>>>> refs/remotes/origin/Genesis

@Controller
@RequestMapping("/lecturerenrolment")
public class LecturerEnrolmentController 
{
<<<<<<< HEAD
	@Autowired
	LecturerService cservice;
=======
>>>>>>> refs/remotes/origin/Genesis
	
	@Autowired
	LecturerService lservice;
	
	//Display All Courses
	@RequestMapping("/home")
	public String showEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		model.addAttribute("allcourses", lservice.listAllcourses());
		return "view-course-enrolment";
	}
	
	//Display Selected Course and its enrolment 
	@RequestMapping("/coursedetail/{courseId}")
<<<<<<< HEAD
	public String enrolmentDetails(@PathVariable("courseId") String courseId, Model model) {
		model.addAttribute("course", cservice.findCourseById(courseId));
		model.addAttribute("enrolments", sservice.listEnrolmentByCourseId(courseId));
=======
	public String enrolmentDetails(@PathVariable("courseId") int courseId, Model model) {
		model.addAttribute("course", lservice.findCourseById(courseId));
		model.addAttribute("enrolments", lservice.listEnrolmentByCourseId(courseId));
>>>>>>> refs/remotes/origin/Genesis
		return "view-course-enrolment-details";
	}

	//Display lecturer Courses 
	@RequestMapping("/gradecourse")
	public String gradeCourse(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		//First find lecturerId from lecturer email 
		int lecturerId = lservice.findLecturerIdbyEmail("XXX@gmail.com");
		//Find courses associated with lecturerId
		model.addAttribute("courses",lservice.findCourseNamesByLecturerId(lecturerId));
		
		//Learn AJAX
		//Use selected Course from dropdown to display enrolment from CourseId
		
		//Simulate Retrieved Course name , Check how to return from HTML
		int courseId = 1001;
		//List Student enrolments via course Id
		model.addAttribute("enrolments", lservice.listEnrolmentByCourseId(courseId));
		return "grade-course";
	}
	
	@RequestMapping("/performance")
	public String performance(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		return "view-student-performance";
	}
	
}
