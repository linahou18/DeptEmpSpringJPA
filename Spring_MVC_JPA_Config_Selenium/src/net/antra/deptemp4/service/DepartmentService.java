package net.antra.deptemp4.service;

import java.util.List;

import net.antra.deptemp4.entity.Department;

public interface DepartmentService {

	public void saveDept(Department dept);

	public List<Department> loadDeptDetails();

	public List<Department> loadDeptBasicInfo();
	
	public Department findChosenDept(int deptId);

	public Department loadDeptDetailById(int id);
	
}
