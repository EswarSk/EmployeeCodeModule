package com.cg.ems.EmployeeCodeModule.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;
import com.cg.ems.EmployeeCodeModule.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployee() {
	return (List<Employee>)repo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return repo.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(Employee emp) {
	 repo.save(emp);

	}

	@Override
	public Employee addEmployee(Employee emp) {
	return repo.save(emp);
	}

}
