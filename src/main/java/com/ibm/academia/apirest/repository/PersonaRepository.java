package com.ibm.academia.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.models.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
	
	@Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	
	@Query("select p from Persona p where p.curp = ?1")
	public Optional<Persona> buscarPorCurp(String dni);
	
	@Query("select p from Persona p where p.apellido like %?1%")
	public Iterable<Persona> buscarPersonaPorApellido(String apellido);
	
	@Query(value = "select * from validar_perfil.personas where id = ?1", nativeQuery = true)
	public Persona buscarPorId(Integer id);

}
