package br.com.domainconsult.apir.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.domainconsult.apir.entities.Employee;
import br.com.domainconsult.apir.services.EmployeeService;

@RestController
@RequestMapping("/apir/employees")
public class EmpRest {
		
	Logger logger = Logger.getLogger(EmpRest.class);
	
	@Autowired
	@Qualifier("employeeService")
	EmployeeService employeeServiceImpl;
	List<Employee> empBeanList = new ArrayList<Employee>();

	
	@GetMapping(value = "/listar")
	public @ResponseBody String getEmployeeJSON(){
		Gson gson = new Gson();
		String jsonEmployee="";
		try{
			
			empBeanList= employeeServiceImpl.getListEmployee();
			logger.info("Quantidade de funcionarios: "+empBeanList.size());
			jsonEmployee = gson.toJson(empBeanList);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonEmployee;
	}
	
}
