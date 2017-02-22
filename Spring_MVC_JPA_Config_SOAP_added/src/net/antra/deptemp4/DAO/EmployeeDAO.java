package net.antra.deptemp4.DAO;

import java.util.List;

import net.antra.deptemp4.entity.Employee;

public interface EmployeeDAO {

	void add(Employee emp);

	List<Employee> getEmployeeList();
}
