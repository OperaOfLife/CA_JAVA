package sg.edu.iss.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.service.AdminService;
import sg.edu.iss.caps.service.AdminServiceImpl;

@Controller
@RequestMapping("/adminenrolment")
public class AdminEnrolmentController
{
	@Autowired
    AdminService as;
	
	/*
	 * @RequestMapping("/list") public String showHome(@ModelAttribute("enrolment")
	 * Enrolment enrolment,Model model) { return "manage-enrolments"; }
	 */
	
	@Autowired
	public void setAdminService(AdminServiceImpl asi) {
		this.as = asi;
	}
	
	
	@RequestMapping("/Manageer")
	public String me() {
		return "manage-enrolments";
	}
	
	@RequestMapping(value = "/list")
	public String listall(Model model) {
		model.addAttribute("enrollments", as.findAllEnrollment());
		return "manage-enrolments";
	}
	@RequestMapping(value = "/adderm")
	public String addlist(Model model) {
		Enrolment e1 = new Enrolment();
		model.addAttribute("addenrollment", e1); //key - "enrollment"
		return "add-enrolments";
	}
	
	@RequestMapping(value = "/editerm/{id}")
	public String editlist(@PathVariable("id") int id, Model model) {
		model.addAttribute("addenrollment", as.findEnrollmentById(id));
		return "add-enrolments";
	}
	@RequestMapping(value = "/saveerm")
	public String savelist(@ModelAttribute("addenrollment") Enrolment addenrollment, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "add-enrolments";
		}
		as.saveEnrollment(addenrollment);
		return "forward:/enrolment/list";
	}
	@RequestMapping(value = "/deleteerm/{id}")
	public String deletefacility(@PathVariable("id") Integer id) {
		as.deletefacility(as.findEnrollmentById(id));
		return "forward:/enrolment/list";
	}
	

}
