package net.antra.deptemp4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.antra.deptemp4.entity.Employee;
import net.antra.deptemp4.service.DepartmentService;
import net.antra.deptemp4.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService ems;
	
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping("/employee")
	public String goToEmployee(ModelMap model) {
		model.addAttribute("employeeList", ems.loadEmpBasicInfo());
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "emp";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String showAddEmp(Employee emp, ModelMap model, @RequestParam("deptSelect") Integer deptId) {
		//int deptId = Integer.parseInt(request.getParameter("deptSelect"));
		emp.setDepartment(deptService.findChosenDept(deptId));
		ems.saveEmp(emp);
		model.addAttribute("employeeList", ems.loadEmpBasicInfo());
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "emp";
	}
	

}
