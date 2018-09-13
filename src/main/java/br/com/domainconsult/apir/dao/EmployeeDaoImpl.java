package br.com.domainconsult.apir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		
		entityManger.merge(employee);
		flagsave=true;
		
		return flagsave;
	}

	@SuppressWarnings("rawtypes")
	public Employee getByIdEmployee(Long id) {
		Query query = entityManger.createQuery("FROM Employee as e where e.empid=:id");
		query.setParameter("id", id);
		List queryList = query.getResultList();
		if(queryList.size()>0){
			return (Employee)queryList.get(0);
		}else{
			return null;
		}
		
	}

	public boolean DeleteEmployee(Long id) {
		// TODO Auto-generated method stub
		boolean flagsave=false;
		Query query = entityManger.createQuery("delete FROM Employee as e where e.empid=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		flagsave=true;
		return flagsave;
	}
	
}
