package com.cg.ems.EmployeeCodeModule.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;
import com.cg.ems.EmployeeCodeModule.Repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	@PostMapping(value="/add")
	public Employee addStudent(@RequestBody Employee emp ) {
		return repo.save(emp);
		
	}
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getAllEmployee()
	{
		return (List<Employee>) repo.findAll();
	}
	
	@GetMapping("/{EmployeeId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getEmployeeById(@PathVariable("EmployeeId") int id)
	{
		List<Employee> list=new ArrayList<>();
		Employee emp= repo.findById(id).get();
		list.add(emp);
		System.out.println(list.size());
		return list;
	}
	
	

}
