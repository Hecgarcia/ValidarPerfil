package com.ibm.academia.apirest.services;




import com.ibm.academia.apirest.models.entities.PasionTarjeta;

public interface PasionTarjetaDAO extends GenericoDAO<PasionTarjeta> {
	
	public PasionTarjeta findByPasionSueldoEdad (String nombrePasion, Integer sueldo, Integer edad);
	
	Boolean validarDatos(String nombrePasion, Integer sueldo, Integer edad);
	
	
}
