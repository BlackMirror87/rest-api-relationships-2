package com.example.restapirelationship3;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.*;
import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.repository.EmployeeRepository;


@DataJpaTest
@Rollback(false)
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void shouldReturnEmployeeByName() {

		Employee employee = new Employee();
		employee.setName("max");
		employeeRepository.save(employee);

		Employee expectedEmployee = employeeRepository.findByName(employee.getName());

		assertThat(expectedEmployee.getName()).isEqualTo(employee.getName());
	}
	

}
