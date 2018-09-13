package br.com.domainconsult.apir.dao;

import java.util.List;

import br.com.domainconsult.apir.entities.Employee;

public interface EmployeeDao {
	
	public List<Employee> getListEmployee();
	public boolean addEmployee(Employee employee);
	public Employee getByIdEmployee(Long id);
	public boolean DeleteEmployee(Long id);	

}
