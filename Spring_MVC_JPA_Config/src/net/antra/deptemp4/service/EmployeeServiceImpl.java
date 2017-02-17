package net.antra.deptemp4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deptemp4.DAO.EmployeeDAO;
import net.antra.deptemp4.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO empDAO;

	@Override
	@Transactional
	public void saveEmp(Employee emp) {
		empDAO.add(emp);
	}

	@Override
	@Transactional
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.getEmployeeList();
	}

}
