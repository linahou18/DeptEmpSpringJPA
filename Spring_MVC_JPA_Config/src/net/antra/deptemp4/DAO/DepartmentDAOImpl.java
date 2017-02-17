package net.antra.deptemp4.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.antra.deptemp4.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Department dept) {
		em.persist(dept);
	}

	@Override
	public List<Department> findAllDepartments() {
		Query query = em.createQuery("select DISTINCT d from Department d LEFT JOIN FETCH d.employeeList");
		return query.getResultList();
	}

	@Override
	public List<Department> findBasicDeptInfo() {
		Query query = em.createQuery("select DISTINCT OBJECT(d) from Department d ");
		return query.getResultList();
	}

	@Override
	public Department findChosenDept(int deptId) {
		return em.find(Department.class, deptId);
	}

}
