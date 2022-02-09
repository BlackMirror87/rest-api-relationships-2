package com.example.restapirelationship3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.repository.EmployeeRepository;

@Service
public class EmployeeManager {
	
	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee save(Employee employee){
		Employee employee2 = new Employee();
		employee2.setName(employee.getName());

		Telephone telephone = new Telephone();
		telephone.addEmployee(employee2);
		
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
