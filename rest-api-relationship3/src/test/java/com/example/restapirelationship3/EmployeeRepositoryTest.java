package com.example.restapirelationship3;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.repository.EmployeeRepository;

@DataJpaTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	@Order(1)
	public void saveEmployeeTest() {

		Employee employee = Employee.builder().name("ola").build();
		employeeRepository.save(employee);
		assertThat(employee.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void findEmployeeByIdTest() {

		Long id = 1L;
		Employee employee = employeeRepository.findById(id).get();
		assertThat(employee.getId()).isEqualTo(id);
	}

	@Test
	@Order(3)
	public void findEmployeeByNameTest() {

		String name = "ola";
		List<Employee> employees = employeeRepository.findByName(name);
		assertThat(employees.contains(name));
	}

	@Test
	@Order(4)
	public void findAllEmployeesTest() {

		List<Employee> employees = employeeRepository.findAll();
		assertThat(employees.size()).isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void updateEmployeeTest() {

		Long id = 1L;
		Employee employee = employeeRepository.findById(id).get();
		employee.setName("max");
		Employee newEmployee = employeeRepository.save(employee);
		assertThat(newEmployee.getName()).isEqualTo("max");
	}

	@Test
	@Order(6)
	public void deleteEmployeeByIdTest() {
		Long id = 1L;
		Employee employee = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		Employee deletedEmployee = employeeRepository.findById(id).orElse(null);
		assertThat(deletedEmployee).isNull();

	}
}
