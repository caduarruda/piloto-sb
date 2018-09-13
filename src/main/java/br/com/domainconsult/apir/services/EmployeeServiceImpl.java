package br.com.domainconsult.apir.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.domainconsult.apir.entities.Employee;

import br.com.domainconsult.apir.dao.EmployeeDao;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	@Qualifier("employeeDAO")
	EmployeeDao employeeDaoImpl;

	public List<Employee> getListEmployee() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getListEmployee();
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.addEmployee(employee);
	}

	public Employee getByIdEmployee(Long id) {
		return employeeDaoImpl.getByIdEmployee(id);
	}
	
	public boolean DeleteEmployee(Long id) {
		return employeeDaoImpl.DeleteEmployee(id);
	}

	
}
