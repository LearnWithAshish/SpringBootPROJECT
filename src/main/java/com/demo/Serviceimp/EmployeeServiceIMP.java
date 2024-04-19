package com.demo.Serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Employee;
import com.demo.Repo.EmpRepository;
import com.demo.Service.EmployeeService;
import com.demo.customException.buisnessException;
import com.demo.globalException.emptyInputException;
@Service
public class EmployeeServiceIMP implements EmployeeService {
	@Autowired
 private EmpRepository empRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
	if (employee.getName().isEmpty()||employee.getName().length()==0) {
		throw new emptyInputException("601","please send proper name, its blank");	
	}
		Employee addedEmployee =empRepository.save(employee);
		return addedEmployee;
	
		
	}

	@Override
	public List<Employee> gatAllEmployee(Employee employee) {
		List<Employee> getallEmployee=null;
		 List<Employee> getallEmployee1=(List<Employee>) empRepository.findAll();
		 try {
			
					 		
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (getallEmployee.isEmpty()) {
			throw new buisnessException("604","hey list is completely empty ,we have nothing to show")
;
		}
		return getallEmployee;
		
	}

	@Override
	public Employee getSingle(Long employeeid) {
		
		return  empRepository.findById(employeeid).get();
	}

	@Override
	public void deletebyID(Long empid) {
		empRepository.deleteById(empid);
		
	}
@Override
	public Employee AddEmployee(Employee employee) {
		Employee update =empRepository.save(employee);	
		return update;
	}


}
