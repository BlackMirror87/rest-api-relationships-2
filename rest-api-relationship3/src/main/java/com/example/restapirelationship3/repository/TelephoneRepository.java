package com.example.restapirelationship3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapirelationship3.model.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
