package br.com.domainconsult.apir.services;

import java.util.List;

import br.com.domainconsult.apir.entities.Employee;

public interface EmployeeService {

	public List<Employee> getListEmployee();
	public boolean addEmployee(Employee employee);
	
}
