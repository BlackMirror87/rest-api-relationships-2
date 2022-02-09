package com.example.restapirelationship3.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.service.TelephoneManager;

@RestController
public class TelephoneController {

	TelephoneManager telephoneManager;

	@Autowired
	public TelephoneController(TelephoneManager telephoneManager) {
		super();
		this.telephoneManager = telephoneManager;
	}

	@PostMapping("/telephones")
	public Telephone addTelephone(@RequestBody Telephone telephone) {
		return telephoneManager.save(telephone);
	}

	@GetMapping("/telephones")
	public List<Telephone> findTelephones() {
		return telephoneManager.findAll();
	}

}
