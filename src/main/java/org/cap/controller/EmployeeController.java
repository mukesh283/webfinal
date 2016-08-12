package org.cap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.cap.pojo.Employee;
import org.cap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employeeForm")
	public String showEmployeeForm(ModelMap map){
		//Map<String, Object> map=new HashMap<>();
		map.put("emp", new Employee());
		map.put("deps", getAllDepartments());
		map.put("employees", employeeService.getAllEmployees());
		
		return "employee";
	}
	
	@RequestMapping(value="/empSave",method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
			BindingResult results,ModelMap map){
		//System.out.println(employee);
		map.put("deps", getAllDepartments());
		map.put("employees", employeeService.getAllEmployees());
		
		if(results.hasErrors()){
			return "employee";
		}else{
		employeeService.saveEmployee(employee);
			return "redirect:employeeForm";
		}
	}
	
	
	
	public List<String> getAllDepartments(){
		List<String> departs=new ArrayList<>();
		departs.add("Sales");
		departs.add("Purchase");
		departs.add("Finance");
		departs.add("Marketing");
		departs.add("HR");
		departs.add("Training");
		return departs;
	}
	
	@RequestMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer employeeId){
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employeeForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
