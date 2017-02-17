package net.antra.deptemp4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.antra.deptemp4.entity.Department;
import net.antra.deptemp4.service.DepartmentService;

@Controller
public class DeptController {
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping("/department")
	public String goToDepartment(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "dept";
	}

	@RequestMapping(value = "/addDept",method = RequestMethod.POST)
	public String showAddDept(Department dept, ModelMap model) {
		deptService.saveDept(dept);
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "dept";
	}
}
