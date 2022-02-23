package com.example.restapirelationship3.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapirelationship3.RestApiRelationship3Application;
import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.service.EmployeeManager;
import com.example.restapirelationship3.service.TelephoneManager;

@RestController
public class TelephoneController {

	TelephoneManager telephoneManager;
	EmployeeManager employeeManager;

	@Autowired
	public TelephoneController(TelephoneManager telephoneManager, EmployeeManager employeeManager) {
		this.telephoneManager = telephoneManager;
		this.employeeManager= employeeManager;
	}


	@PostMapping("/telephones")
	public Telephone addTelephone(@RequestBody Telephone telephone) {
		
		Telephone telephone2 = new Telephone();
		telephone2.setNumber(telephone.getNumber());
		telephone2.setEmployees(telephone.getEmployees());
		
		return telephoneManager.save(telephone2);
	}
	

	@GetMapping("/telephones")
	public List<Telephone> findTelephones() {
		return telephoneManager.findAll();
	}

}
