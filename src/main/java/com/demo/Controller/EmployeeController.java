package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Employee;
import com.demo.Service.EmployeeService;
@Component
@RestController
@RequestMapping("/home")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
	  Employee employeesaved=	employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeesaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>>  getALLEmployee(@RequestBody Employee employee){
	List<Employee> listofEmployees =	employeeService.gatAllEmployee(employee);
		return new  ResponseEntity<List<Employee>>(listofEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{id}")//if i get the employee by using unexisted id it will throw exception so i need to handle it
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id")Long emplyeeid){
		 Employee  e=employeeService.getSingle(emplyeeid);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletebyempid(@PathVariable("id")Long empid){
		employeeService.deletebyID(  empid);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee EmpSaved=employeeService.AddEmployee(employee);
		return new ResponseEntity<Employee>(EmpSaved,HttpStatus.CREATED);		
		
	}

	
	
	
}
