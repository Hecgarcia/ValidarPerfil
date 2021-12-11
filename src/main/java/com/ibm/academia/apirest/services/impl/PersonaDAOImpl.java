package com.ibm.academia.apirest.services.impl;

import java.util.Optional;

import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repository.PersonaRepository;
import com.ibm.academia.apirest.services.PersonaDAO;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

	public PersonaDAOImpl(PersonaRepository repository) {
		super(repository);
		 
	}

	@Override
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
		 
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	public Optional<Persona> buscarPorDni(String dni) {
		 
		return repository.buscarPorCurp(dni);
	}

	@Override
	public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
		 
		return repository.buscarPersonaPorApellido(apellido);
	}

}
