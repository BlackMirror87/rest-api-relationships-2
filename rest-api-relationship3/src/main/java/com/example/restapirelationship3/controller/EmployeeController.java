package com.example.restapirelationship3.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/employees/{name}")
	public Employee findEmployeeByName(@PathVariable String name) {
		return employeeManager.findByName(name);
	}

	@GetMapping("/employees/{id}")
	public Employee findEmployeeById(@PathVariable Long id) {
		return employeeManager.findById(id);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employee2 = new Employee();
		employee2.setName(employee.getName());
		employee2.setTelephones(employee.getTelephones());

		return employeeManager.save(employee);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {

		Employee employee = employeeManager.findById(id);
				
		employee.setName(newEmployee.getName());
		employee.setTelephones(newEmployee.getTelephones());

		return employeeManager.save(employee);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		employeeManager.deleteById(id);
	}

}
