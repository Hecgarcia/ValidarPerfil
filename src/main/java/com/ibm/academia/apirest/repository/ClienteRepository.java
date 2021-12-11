package com.ibm.academia.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.academia.apirest.models.entities.Persona;

public interface ClienteRepository extends JpaRepository<Persona, Integer> {
	
	

}
