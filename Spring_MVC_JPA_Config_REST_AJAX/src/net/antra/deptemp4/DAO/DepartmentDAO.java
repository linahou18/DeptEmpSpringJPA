package net.antra.deptemp4.DAO;

import java.util.List;

import net.antra.deptemp4.entity.Department;

public interface DepartmentDAO {

	void save(Department dept);

	List<Department> findAllDepartments();

	List<Department> findBasicDeptInfo();
	
	Department findChosenDept(int deptId);

	Department findDepartmentById(int id);
}
