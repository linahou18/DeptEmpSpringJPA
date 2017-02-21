package net.antra.deptemp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.antra.deptemp4.service.DepartmentService;

@Controller
public class MainController {
	
//	@RequestMapping("/main")
//	public String showMain(ModelMap model) {
//		model.addAttribute("user", "Antra!");
//		return "welcome";
//	}
	
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping("/main")
	public String showMain(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "welcome";
	}
}