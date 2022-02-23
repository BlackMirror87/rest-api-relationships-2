package com.example.restapirelationship3.model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Telephone {

	private Integer number;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToMany(mappedBy = "telephones", cascade = CascadeType.ALL)
	Set<Employee> employees = new HashSet<>();

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		employee.getTelephones().add(this);
	}


}
