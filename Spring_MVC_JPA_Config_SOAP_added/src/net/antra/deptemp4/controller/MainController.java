package net.antra.deptemp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.antra.deptemp4.entity.Department;
import net.antra.deptemp4.service.DepartmentService;
import net.antra.deptemp4.service.GeoIPDelegateService;

@Controller
public class MainController {
	
//	@RequestMapping("/main")
//	public String showMain(ModelMap model) {
//		model.addAttribute("user", "Antra!");
//		return "welcome";
//	}
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	GeoIPDelegateService geoIPDelegateService;
	
	@RequestMapping("/getCountryName")
	@ResponseBody
	public String getCountryName(@RequestParam String ip) {
		System.out.println("jump into controller test");
		System.out.println("test result " + geoIPDelegateService.getCountryName(ip));
		return geoIPDelegateService.getCountryName(ip);
	}
	
	@RequestMapping("/main")
	public String showMain(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "welcome";
	}
}