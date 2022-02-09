package com.example.restapirelationship3.service;

import java.util.List;
import java.util.Optional;

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
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}
}
