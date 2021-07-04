package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.StudentRepository;

@Controller
@RequestMapping("/adminstudent")
public class AdminStudentController 
{
	@Autowired
	StudentRepository srepo;

	
	  
	  @RequestMapping("/list")
	  public String listStudents(Model model) {
	    List<Student> students = (List<Student>) srepo.findAll();
	    model.addAttribute("students", students);
	    
	    return "manage-students";
	  }
	  
	  @RequestMapping("/add")
	  public String showStudentForm(Model model)
	  {
	    Student student = new Student();
	    model.addAttribute("student", student);
	    return "add-students";
	  }
	  
	  @RequestMapping("/save")
	  public String saveCourseForm(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors())
	    {
	      return "add-students";
	    }
	    srepo.save(student);
	    return "forward:/adminstudent/list";
	  }
	  
	  @RequestMapping("/edit/{studentId}")
		public String showEditForm(Model model, @PathVariable("studentId") String studentId) {
			model.addAttribute("student", srepo.findById(studentId).get());
			
			return "add-students";
		}
		
		@RequestMapping("/delete/{studentId}")
		public String deleteMethod(Model model, @PathVariable("studentId") String studentId) 
		{
			String msg="Can not delete ... delete records from linked table first";
			Student student= srepo.findById(studentId).get();
			try
			{
			srepo.delete(student);
			}
			catch(Exception e)
			{
				model.addAttribute("errmsg", msg);
				return "forward:/adminstudent/list";
			}
			return "forward:/adminstudent/list";
		}
	
	
}
