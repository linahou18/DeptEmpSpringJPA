package net.antra.deptemp4.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.antra.deptemp4.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void add(Employee emp) {
		em.persist(emp);
	}

	@Override
	public List<Employee> getEmployeeList() {
		Query query = em.createQuery("select DISTINCT OBJECT(e) from Employee e ");
		return query.getResultList();
	}

}
