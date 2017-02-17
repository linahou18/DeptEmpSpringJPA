package net.antra.deptemp4.service;

import java.util.List;

import net.antra.deptemp4.entity.Employee;

public interface EmployeeService {
	
	public void saveEmp(Employee emp);

	public List<Employee> loadEmpBasicInfo();
	
}
