package com.ibm.academia.apirest.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.PasionTarjeta;

@Repository
public interface PasionTarjetaRepository extends CrudRepository<PasionTarjeta, Integer> {

	@Query( "select p from PasionTarjeta p where p.nombrePasion = ?1 and p.sueldoMinimo<=?2 "
		   + "and sueldoMaximo>=?2 and edadMinima<=?3 and edadMaxima>=?3")
	Iterable<PasionTarjeta> findByPasionSueldoEdad (String nombrePasion, Integer sueldo, Integer edad);
	
	@Query( "select p.tarjetaPasion from PasionTarjeta p where p.nombrePasion = ?1 and p.sueldoMinimo<=?2 "
			   + "and sueldoMaximo>=?2 and edadMinima<=   ?3 and edadMaxima>=?3")
	public PasionTarjeta validarDatos(String nombrePasion, Integer sueldo, Integer edad);

	@Query( "select p.tarjetaPasion from PasionTarjeta p where p.nombrePasion = ?1 and p.sueldoMinimo<=?2 "
			   + "and sueldoMaximo>=?2 and edadMinima<=   ?3 and edadMaxima>=?3")
	Iterable<PasionTarjeta> findByPasionSueldoEdadTarjeta(String nombrePasion, Integer sueldo, Integer edad);
		
}
