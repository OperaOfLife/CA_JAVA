package sg.edu.iss.caps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.service.LecturerService;

@Controller
@RequestMapping("/lecturerenrolment")
public class LecturerEnrolmentController 
{

	@Autowired
	LecturerService lservice;
	
	//Display All Courses 1/2
	@RequestMapping("/home")
	public String showEnrolment(@ModelAttribute("courses") Course courses,Model model)
	{
		model.addAttribute("allcourses", lservice.listAllcourses());
		return "view-course-enrolment";
	}
	
	//Display Selected Course and its enrolment 2/2
	@RequestMapping("/coursedetail/{courseId}")
	public String enrolmentDetails(@PathVariable("courseId") String courseId, Model model) {
		model.addAttribute("course", lservice.findCourseById(courseId));

		model.addAttribute("enrolments", lservice.listEnrolmentByCourseId(courseId));
		return "view-course-enrolment-details";
	}

	//Display lecturer Courses 1/4
	@RequestMapping("/gradecourse")
	public String gradeCourse(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{

		//First find lecturerId from lecturer email 
		String lecturerId = lservice.findLecturerIdbyEmail("tin@gmail.com");
		//Find courses associated with lecturerId
		model.addAttribute("courses",lservice.findCoursesByLecturerId(lecturerId));
		return "grade-course";
	}
	
	//Display enrolments by course id 2/4
	@RequestMapping("/getEnrolments/{courseId}")
	public String getEnrolmentsByCourseId(@PathVariable("courseId") String courseId, Model model) {
		model.addAttribute("enrolments", lservice.listEnrolmentByCourseId(courseId));
		return "grade-course-2";
	}
	
	//Display students by enrolment id 3/4
	@RequestMapping("/editGrades/{enrolmentid}")
	public String showUpdateGrades(@PathVariable("id") int id, Model model) {
		Enrolment enrolment = lservice.listEnrolmentByEnrolmentId(id);
		
		model.addAttribute("enrolment", enrolment);
		return "grade-course-3";
	}

	//Update grades
	@RequestMapping("/updateGrades/{enrolmentid}")
	public String updateGrades(@PathVariable("enrolmentid") int id,Enrolment enrolment, BindingResult result, Model model) {
		if(result.hasErrors()) {
			enrolment.setEnrolmentId(id);
			return "grade-course-3";
		}
		
		lservice.saveUpdatedGrades(enrolment);
		return "forward:/editGrades/{enrolmentid}";
	}
	@RequestMapping("/performance")
	public String performance(@ModelAttribute("enrolment") Enrolment enrolment,Model model)
	{
		return "view-student-performance";
	}
	
}
