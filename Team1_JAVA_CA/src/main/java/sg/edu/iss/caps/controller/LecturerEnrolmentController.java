package sg.edu.iss.caps.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
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
		model.addAttribute("courses", lservice.listAllcourses());
		return "view-course-enrolment";
	}
	
	//Display Selected Course and its enrolment 2/2
	@RequestMapping("/coursedetail/{courseId}")
	public String enrolmentDetails(@PathVariable("courseId") String courseId, Model model) {
		model.addAttribute("course", lservice.findCourseById(courseId));

		model.addAttribute("enrolments", lservice.listEnrolmentByCourseId(courseId));
		return "view-course-enrolment-details";
	}

	@RequestMapping("/gradecourse") 
	 public String gradeCourse(Model model,HttpSession session) 
	 { 
	 
		UserSession usession = (UserSession) session.getAttribute("usession");
		String currentusername=usession.getUser().getUsername();
	  //Find courses associated with lecturerId 
	  model.addAttribute("courses",lservice.listCourseNamesByLecturerEmail(currentusername)); 
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
	public String showUpdateGrades(@PathVariable("enrolmentid") int id, Model model) {
		//Enrolment enrolment = lservice.listEnrolmentByEnrolmentId(id);
		
		model.addAttribute("enrolment", lservice.listEnrolmentByEnrolmentId(id));
		return "grade-course-3";
	}

	//Update grades
	/*
	 * @RequestMapping("/updateGrades/{enrolmentid}") public String
	 * updateGrades(@PathVariable("enrolmentid") int id,Enrolment enrolment,
	 * BindingResult result, Model model) { if(result.hasErrors()) {
	 * enrolment.setEnrolmentId(id); return "grade-course-3"; }
	 * 
	 * lservice.saveUpdatedGrades(enrolment); return
	 * "forward:/editGrades/{enrolmentid}"; }
	 */
	 @RequestMapping("/updateGrades/{enrolmentid}") 
	 public String updateGrades(@PathVariable("enrolmentid") int id, @ModelAttribute("enrolment") Enrolment enrolment, BindingResult result, Model model) { 
	  if(result.hasErrors()) { 
	   return "grade-course-3"; 
	  } 
	   
	  Optional<Enrolment> enrolled = lservice.findByEnrolmentId(id); 
	  if(enrolled.isPresent()) 
	  { 
	   Enrolment e = enrolled.get(); 
	   if(enrolment.getEnrolmentDate() != null) 
	    e.setEnrolmentDate(enrolment.getEnrolmentDate()); 
	   if(enrolment.getGrade() != null) 
	    e.setGrade(enrolment.getGrade()); 
	   
	   if(enrolment.getStatus() != null) 
	    e.setStatus(enrolment.getStatus()); 
	   
	   lservice.saveUpdatedGrades(e); 
	  } 
	  return "forward:/lecturerenrolment/gradecourse"; 
	 }
	
	
	@RequestMapping("/performance")
	public String performance(Model model, @Param("keyword") String keyword){
		List<Enrolment> listEnrolments = lservice.listAll(keyword);
		model.addAttribute("listenrolments", listEnrolments);
		model.addAttribute("keyword", keyword);
		return "view-student-performance";
	}

	
}
