package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.EnrolmentStatus;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.service.LecturerService;

@Controller
@RequestMapping("/courselecturer")
public class LecturerCourseLecturerController
{
	
	@Autowired
	LecturerService lservice;
	
	
	
	
	
	@RequestMapping(value ="/add") 
	 public String addCourses(Model model)
	{ 
	  //add new course form 
	  model.addAttribute("addcourse", new CourseLecturer()); 
	  //extract names from DB 
	  ArrayList<String> clist = lservice.findAllCourseName(); 
	  ArrayList<String> llist = lservice.findAllLecturerNames(); 
	  model.addAttribute("cnames", clist); 
	  model.addAttribute("lnames", llist); 
	  //direct to html 
	  return "add-course-lecturer-form"; 
	 } 
	  
	 @RequestMapping(value = "/save") 
	 public String saveCourseTaught (@ModelAttribute("addcourse")  CourseLecturer courselecturer,BindingResult bindingResult, Model model) { 
	  if(bindingResult.hasErrors()) { 
	   return "addcourseform"; 
	  } 
	  //Lecturer Id 
	  Lecturer lecturer = lservice.findLecturerByName(courselecturer.getLecturer().getFirstName()); 
	  lecturer = lservice.findLecturerById(lecturer.getLecturerId()); 
	  courselecturer.setLecturer(lecturer); 
	  //Course Id 
	  Course course = lservice.findCourseByName(courselecturer.getCourses().getCourseName()); 
	  course = lservice.findCourseById(course.getCourseId()); 
	  courselecturer.setCourses(course); 
	  
	  lservice.addCousesTaught(courselecturer); 
	  //} 
	  return "forward:/lecturerenrolment/add"; 
	 }
	
	
	@RequestMapping("/home")
	public String showHome(@ModelAttribute("courses") Course courses, Model model, HttpSession session)
	{
		UserSession usession = (UserSession) session.getAttribute("usession");
		String currentusername=usession.getUser().getUsername();
		List<CourseLecturer> course =lservice.listCourseNamesByLecturerEmail(currentusername);
		model.addAttribute("ldata", course);
		ArrayList<Integer>  count=new ArrayList<>();
		
		/*
		 * for(CourseLecturer cl:course) { List<Enrolment> enrol =
		 * cl.getCourses().getEnrolment(); //should i loop through each course to get
		 * enrolment separately instead?
		 * 
		 * for (Enrolment e:enrol) {
		 * 
		 * if (e.getStatus().ordinal() == 0) count.add(enrol.size()); } }
		 */
		
		  for(CourseLecturer cl:course) {
		  
		  List<Enrolment> enrol =cl.getCourses().getEnrolment();
		  
		  count.add(enrol.size() ); }
		 
		
		/*
		 * int total=0; for(CourseLecturer cl:course) {
		 * 
		 * List<Enrolment> enrol =cl.getCourses().getEnrolment();
		 * 
		 * for(Enrolment e:enrol) {
		 * 
		 * if(EnrolmentStatus.DEFERRED != e.getStatus()) total=total+1; }
		 * count.add(total ); }
		 */
		  for(CourseLecturer cl:course)
		    {
		      List<Enrolment>  enrol =cl.getCourses().getEnrolment();
		      int enrolledNumber = 0;
		      for (Enrolment e: enrol) {
		        if (e.getStatus() == EnrolmentStatus.ENROLLED) {
		          enrolledNumber++;
		        }
		      }
		    
		      count.add(enrolledNumber);
		    }
		 
		 
		
		
		model.addAttribute("count",count);
		
		return "view-courses-taught";
	}
}
