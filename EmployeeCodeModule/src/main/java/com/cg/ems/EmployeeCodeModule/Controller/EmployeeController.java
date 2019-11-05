package com.cg.ems.EmployeeCodeModule.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;
import com.cg.ems.EmployeeCodeModule.Exception.EmployeeNotFoundException;
import com.cg.ems.EmployeeCodeModule.Repository.EmployeeRepository;
import com.cg.ems.EmployeeCodeModule.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	@PostMapping(value="/add")
	public Employee addEmployee(@RequestBody Employee emp ) {
		return service.addEmployee(emp);
		
	}
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getAllEmployee()
	{
		
		return (List<Employee>) service.getAllEmployee();
	}
	
	@GetMapping("/{EmployeeId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getEmployeeById(@PathVariable("EmployeeId") int id)
	{
		List<Employee> list=new ArrayList<>();
		Optional<Employee> emp =service.getEmployeeById(id);
		if(emp.isPresent())
		{
			Employee emp1= emp.get();
			list.add(emp1);
			return list;
		}
		return list;
			
/*

		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}*/
	}
	@DeleteMapping("/{EmployeeId}")
	public void deleteEmployeeById(@PathVariable("EmployeeId") int id) {
		
		Optional<Employee> emp =service.getEmployeeById(id);
		if(emp.isPresent())
		
service.deleteEmployeeById(id);
		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}
	}
	@PutMapping("/{id}")
	public String update(@RequestBody Employee emp, @PathVariable("id") int id) {
		
		emp.setEmployeeId(id);
		
		Optional<Employee> emp1 =service.getEmployeeById(id);
		if(emp1.isPresent())
		
	service.update(emp);
		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}
		return "Record Updated Successfully";
	}
	
	

}
