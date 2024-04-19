package com.demo.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Model.Employee;

@Service

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> gatAllEmployee(Employee employee);
	public Employee getSingle(Long employeeid);

	public void deletebyID(Long empid);

	public Employee AddEmployee(Employee employee);

}
