package sg.edu.iss.caps.controller;

import java.util.ArrayList;

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
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.service.AdminService;
import sg.edu.iss.caps.service.AdminServiceImpl;
import sg.edu.iss.caps.service.LecturerService;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/adminenrolment")
public class AdminEnrolmentController
{
	@Autowired
    AdminService as;
	
	@Autowired
    StudentService ss;
	
  @Autowired
  CourseRepository crepo;
  
  @Autowired
  StudentRepository srepo;
	
  @Autowired
	LecturerService lservice;
	
	@Autowired
	public void setAdminService(AdminServiceImpl asi) {
		this.as = asi;
	}
	
	@RequestMapping(value = "/adderm")
	  public String addlist(Model model) {
	    Enrolment e1 = new Enrolment();
	    model.addAttribute("addenrollment", e1); //key - "enrollment"
	    ArrayList<Course> courses = (ArrayList<Course>) crepo.findAll();
	    ArrayList<Student> students = (ArrayList<Student>) srepo.findAll();
	    model.addAttribute("courses", courses);
	    model.addAttribute("students", students);
	    return "add-enrolments";
	  }
	
	
	
		
	@RequestMapping(value = "/saveerm")
	  public String savelist(@ModelAttribute("addenrollment") Enrolment addenrollment, 
	      BindingResult bindingResult,  Model model) 
			{
		
		String msg="Course Already added !!!!";
		String msg1="Successfully Added  !!!!";
		
	    if (bindingResult.hasErrors())
	    {
	      return "add-enrolments";
	    }
	    if(as.findEnrolmentByCourseAndStudentId(addenrollment.getStudent().getStudentId(),
	    		addenrollment.getCourse().getCourseId()) == null)
	    {
	    	Student student= ss.findStudentByName(addenrollment.getStudent().getFirstName());
	    	student = ss.findStudentById(addenrollment.getStudent().getStudentId());
	    	addenrollment.setStudent(student);
	    	
	    	Course course = lservice.findCourseByName(addenrollment.getCourse().getCourseName()); 
	 	   course = lservice.findCourseById(course.getCourseId()); 
	 	   addenrollment.setCourse(course);
	 	   
	 	  as.saveEnrollment(addenrollment);
	 	  model.addAttribute("errmsg", msg1);
		    return "forward:/adminenrolment/adderm";
	    }
	     else
		  {
			  model.addAttribute("errmsg", msg);
			  return "forward:/adminenrolment/adderm";
		  }
	    
	   
	    
	    
	  }
	
	
	
	
	
	@RequestMapping("/Manageer")
	public String me() {
		return "manage-enrolments";
	}
	
	@RequestMapping(value = "/list")
	public String listall(Model model) {
		model.addAttribute("enrolments", as.findAllEnrollment());
		return "manage-enrolments";
	}
	
	
	@RequestMapping(value = "/editerm/{id}")
	public String editlist(@PathVariable("id") int id, Model model) 
	{
		ArrayList<Course> courses = (ArrayList<Course>) crepo.findAll();
	    ArrayList<Student> students = (ArrayList<Student>) srepo.findAll();
	    model.addAttribute("courses", courses);
	    model.addAttribute("students", students);
		model.addAttribute("addenrollment", as.findEnrollmentById(id));
		return "add-enrolments";
	}

	
	@RequestMapping(value = "/deleteerm/{id}")
	public String deletefacility(@PathVariable("id") Integer id) {
		as.deletefacility(as.findEnrollmentById(id));
		return "forward:/adminenrolment/list";
	}
	

}
