package br.com.domainconsult.apir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.domainconsult.apir.entities.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	
	@PersistenceContext
    private EntityManager entityManger;

	public List<Employee> getListEmployee() {
		return entityManger.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	public boolean addEmployee(Employee employee) {
		boolean flagsave=false;
		
		entityManger.getTransaction().commit();
		flagsave=true;
		
		return flagsave;
	}

}
