package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired //Annotation based Dependency Injunction (3rd type) , Field Injunction
	private EmployeeService service;
	
	@RequestMapping("home")
	public ModelAndView loadHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		return mv; //Servlet Dispatcher forward
	}
	
	@RequestMapping(value="/employee" , method = RequestMethod.POST , params = "Insert")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) { //@ModelAttribute - Automatically creates bean 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		String result = "";
		boolean status = service.createEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Saved";
		} else {
			result = "FAILED : Employee Object NOT Saved";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value="/employee" , method = RequestMethod.POST , params = "Update")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		String result = "";
		boolean status = service.updateEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Updated";
		} else {
			result = "FAILED : Employee Object NOT Updated";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value="/employee" , method = RequestMethod.POST , params = "Delete")
	public ModelAndView deleteEmployee(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		String result = "";
		boolean status = service.deleteEmployee(eid);
		
		if(status) {
			result = "SUCCESS : Employee Object Deleted";
		} else {
			result = "FAILED : Employee Object NOT Deleted";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value="/employee" , method = RequestMethod.POST , params = "Find")
	public ModelAndView findEmployee(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		String result = "";
		Employee employee = service.findEmployee(eid);
		
		if(employee != null) {
			result = employee.toString();
		} else {
			result = "FAILED : Employee Object NOT Found";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value="/employee" , method = RequestMethod.POST , params = "FindAll")
	public ModelAndView findAllEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		List<Employee> employees = service.findAllEmployee();
		
		
		mv.addObject("result", employees);
		
		return mv;
	}
	
}
