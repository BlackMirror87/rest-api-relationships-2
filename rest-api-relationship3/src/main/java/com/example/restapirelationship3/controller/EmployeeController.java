package com.example.restapirelationship3.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.service.EmployeeManager;

@RestController
public class EmployeeController {

	EmployeeManager employeeManager;

	@Autowired
	public EmployeeController(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeManager.findAll();
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employee2 = new Employee();
		employee2.setName(employee.getName());
		employee2.setTelephones(employee.getTelephones());
		
		return employeeManager.save(employee);
	}

}
