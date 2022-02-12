package com.example.restapirelationship3.model;

import java.util.*;
import javax.persistence.*;
import org.springframework.data.repository.NoRepositoryBean;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Employee {

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_telephone", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "telephone_id"))
	Set<Telephone> telephones = new HashSet<>();

	public void addTelephone(Telephone telephone) {
		this.telephones.add(telephone);
		telephone.getEmployees().add(this);
	}

	public Employee(String string) {
		// TODO Auto-generated constructor stub
	}
}
