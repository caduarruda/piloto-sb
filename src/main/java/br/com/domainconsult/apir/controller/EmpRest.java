package br.com.domainconsult.apir.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping(value="/novofunc")
	public @ResponseBody String saveEmployee(@RequestBody Employee employee){
		boolean getresponse=false;
		String jsonEmployee="";
		try{
			getresponse = employeeServiceImpl.addEmployee(employee);
			jsonEmployee=getresponse==true?"1":"0";
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonEmployee;
	}

    @DeleteMapping(value="/deletefunc/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id ){
		logger.info("Solicitacao de delecao do funcionario:  "+id);
		employeeServiceImpl.DeleteEmployee(new Long(id));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/listarporid/{id}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Employee getOneEmployee (@PathVariable("id") String id){
	   logger.info("Funcionario consultado:  "+id);
	   return employeeServiceImpl.getByIdEmployee(new Long(id));
	}

}
