package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.LecturerRepository;

@Controller
@RequestMapping("/adminlecturer")
public class AdminLecturerController 
{

	@Autowired
    LecturerRepository lrepo;
	
	
	      
	      @RequestMapping("/list")
	      public String listLecturers(Model model) {
	        List<Lecturer> lecturers = (List<Lecturer>) lrepo.findAll();
	        model.addAttribute("lecturers", lecturers);
	        
	        return "manage-lecturers";
	      }
	      
	      @RequestMapping("/add")
	      public String showLecturerForm(Model model)
	      {
	        Lecturer lecturer = new Lecturer();
	        model.addAttribute("lecturer", lecturer);
	        return "add-lecturers";
	      }
	      
	      @RequestMapping("/save")
	      public String saveLecturerForm(@ModelAttribute("lecturer") Lecturer lecturer, BindingResult bindingResult, Model model)
	      {
	        if (bindingResult.hasErrors())
	        {
	          return "add-lecturers";
	        }
	        lrepo.save(lecturer);
	        return "forward:/adminlecturer/list";
	      }
	      
	    
	     @RequestMapping("/edit/{lecturerId}")
	     public String showEditForm(Model model, @PathVariable("lecturerId") String lecturerId)
	     {
	     model.addAttribute("lecturer", lrepo.findById(lecturerId).get());
	     
	     return "add-lecturers";
	     }
	     
	     @RequestMapping("/delete/{lecturerId}")
	     public String deleteMethod(Model model, @PathVariable("lecturerId") String lecturerId) 
	     { 
	       Lecturer lecturer=lrepo.findById(lecturerId).get(); 
	       lrepo.delete(lecturer); 
	         return "forward:/adminlecturer/list";
	     }
}
