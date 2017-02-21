package net.antra.deptemp4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deptemp4.DAO.DepartmentDAO;
import net.antra.deptemp4.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAO deptDAO;

	@Override
	@Transactional
	public void saveDept(Department dept) {
		deptDAO.save(dept);
	}

	@Override
	@Transactional
	public List<Department> loadDeptDetails() {
		return deptDAO.findAllDepartments();
	}

	@Override
	@Transactional
	public List<Department> loadDeptBasicInfo() {
		return deptDAO.findBasicDeptInfo();
	}

	@Override
	public Department findChosenDept(int deptId) {
		return deptDAO.findChosenDept(deptId);
	}

	@Override
	@Transactional
	public Department loadDeptDetailById(int id) {
		Department dept = deptDAO.findDepartmentById(id);
		return dept;
	}

	

}
