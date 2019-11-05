package com.cg.ems.EmployeeCodeModule.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Optional<Employee> getEmployeeById(int id);
	public void deleteEmployeeById(int id); 
		public void update(Employee emp);
		public Employee addEmployee( Employee emp );
	}
		


