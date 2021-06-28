package sg.edu.iss.caps.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.EnrolmentRepository;
import sg.edu.iss.caps.repo.StudentRepository;

@Controller
@RequestMapping("/studentGrades")
public class StudentGradesGPAController 
{
	@Autowired
	EnrolmentRepository erepo;
	
	@Autowired
	StudentRepository srepo;

	 @RequestMapping(value = "/username", method = RequestMethod.GET)
	 @ResponseBody
	 public void currentUserName(Model model,Principal principal)
	 {
	     String currentuser= principal.getName();
	     model.addAttribute("currentuser", currentuser);
	  }
	 
	@RequestMapping(value = "/gradesGPA" , method = RequestMethod.GET)
	public String gradesGPA(Model model, 
								HttpSession session,Authentication authentication )
	{
		/*
		 * String currentuser= authentication.getUsername(); Student
		 * student=srepo.findStudentIdByEmail("kat@gmail.com");
		 */
		Student student=srepo.findStudentIdByEmail("kat@gmail.com");
		List<Enrolment> enrolments = (List<Enrolment>) erepo.findEnrolmentByStudentId(student.getStudentId());
		model.addAttribute("enrolments",enrolments);
		return "grades-gpa";
	}
	
	public String calculate(String grade)
	{
		String gpa="NA";
		if (gpa.equalsIgnoreCase("a"))
			gpa="5";
		else if (gpa.equalsIgnoreCase("b"))
			gpa="4.5";
		else if (gpa.equalsIgnoreCase("c"))
			gpa="4";
		else if (gpa.equalsIgnoreCase("d"))
			gpa="3.5";
		else
			gpa="3";
		return "forward:/studentGrades/gradesGPA";
		
	}
	
}
