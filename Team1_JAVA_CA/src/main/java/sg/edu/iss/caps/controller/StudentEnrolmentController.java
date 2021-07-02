package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.EnrolmentStatus;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.EnrolmentRepository;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/studentEnrolment")
public class StudentEnrolmentController 
{
	
	
	 @Autowired
	  StudentService sservice;
	  
	  @Autowired
	  CourseRepository crepo;
	  
	  @Autowired
	  EnrolmentRepository erepo;
	  
	@RequestMapping("/coursesForEnrolment")
	  public String showCoursesForEnrolment(Model model, HttpSession session)
	  {
	    UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername();
	    ArrayList<Course> courses = (ArrayList<Course>) crepo.findAll();
	    ArrayList<Course> freshCourses = new ArrayList<Course>();
	    
	    for (Course course: courses) 
	    {
	      boolean studentExists = false;
	      List<Enrolment> enrolments = course.getEnrolment();
	      //if (!enrolments.isEmpty()) {
	        for (Enrolment enrolment: enrolments)
	        {

	          if (enrolment.getStudent().getEmail().equals(currentusername)) 
	          {
	            studentExists = true;
	            break;
	          }
	        }
	      //}
	      if (!studentExists) {
	        freshCourses.add(course);
	      }
	      
	    }
	    
	    
	    model.addAttribute("freshCourses", freshCourses);
	    
	    return "view-courses";
	  }
	  
	  @RequestMapping(value = "/enroll/{courseId}")
	  public String addlist(@PathVariable("courseId") String courseId, Model model, HttpSession session) 
	  {
		  String msg="Successful";
		  String msg1="Not Successful";
		  
	    // Session
	    UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername();
	    
	    // Getting student object
	    Student student = sservice.getStudentByEmail(currentusername);
	    
	    // Getting course object
	    Course course = crepo.findByCourseId(courseId);
	    model.addAttribute("enrolledCourse", courseId);
	    
	    if (course.getEnrolment().size() < course.getClassSize()) {
	    // Saving Enrollment
	    Enrolment newEnrollment = new Enrolment();
	    newEnrollment.setCourse(course);
	    newEnrollment.setStudent(student);
	    newEnrollment.setEnrolmentDate(new Date());
	    newEnrollment.setStatus(EnrolmentStatus.ENROLLED);
	    erepo.save(newEnrollment);
	    model.addAttribute("errmsg",msg );
	    return "forward:/studentEnrolment/coursesForEnrolment";
	    }
	    else {
	    	model.addAttribute("errmsg",msg1 );
	      return "forward:/studentEnrolment/coursesForEnrolment";
	    }
	  }

		
	@RequestMapping("/enrolledCourses")
	public String showEnrolledCourses(@ModelAttribute("courses") Course courses,Model model,
						HttpSession session)
	{
		UserSession usession = (UserSession) session.getAttribute("usession");
		String currentusername=usession.getUser().getUsername();
		model.addAttribute("sdata", sservice.listCoursesEnrolledByStudentEmail(currentusername));
		return "enrolled-courses";
	}
}
