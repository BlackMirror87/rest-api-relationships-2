package com.example.restapirelationship3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.assertj.core.error.ShouldAccept;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.repository.EmployeeRepository;
import com.example.restapirelationship3.service.EmployeeManager;

@ExtendWith(MockitoExtension.class)
class EmployeeManagerTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeManager employeeManager;

	@Test
	void shouldSaveEmployee() {

		Employee employee = new Employee();
		employee.setName("jan");

		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

		Employee savedEmployee = employeeManager.save(employee);

		assertThat(savedEmployee.getName()).isSameAs(employee.getName());
	}

	@Test
	void shouldReturnAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("max"));
		employees.add(new Employee("jan"));

		when(employeeRepository.findAll()).thenReturn(employees);

		List<Employee> expectedEmployees = employeeManager.findAll();

		assertEquals(expectedEmployees, employees);
	}

	@Test
	void shouldReturnEmployeeWhenIdExists() {

		Employee employee = new Employee();
		employee.setId(1L);

		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

		Employee expectedEmployee = employeeManager.findById(employee.getId());

		assertThat(expectedEmployee).isSameAs(employee);
	}

	@Test
	void shouldThrowExceptionWhenEmployeeNotExist() {

		Employee employee = new Employee();
		employee.setId(1L);

		when(employeeRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(NoSuchElementException.class, () -> employeeManager.findById(123L));
	}

	@Test
	void shouldDeleteEmployeeById() {

		Employee employee = new Employee();
		employee.setId(1L);

		employeeManager.deleteById(employee.getId());

		verify(employeeRepository).deleteById(employee.getId());
	}

}
