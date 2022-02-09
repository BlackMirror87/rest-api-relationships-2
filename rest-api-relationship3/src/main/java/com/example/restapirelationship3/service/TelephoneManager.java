package com.example.restapirelationship3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapirelationship3.model.Employee;
import com.example.restapirelationship3.model.Telephone;
import com.example.restapirelationship3.repository.TelephoneRepository;

@Service
public class TelephoneManager {

	TelephoneRepository telephoneRepository;

	@Autowired
	public TelephoneManager(TelephoneRepository telephoneRepository) {
		super();
		this.telephoneRepository = telephoneRepository;
	}
	
	
	public List<Telephone> findAll(){
		return telephoneRepository.findAll();
	}
	
	
	public Telephone save(Telephone telephone) {
		return telephoneRepository.save(telephone);
	}
}
