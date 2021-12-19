package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.PasionTarjeta;
import com.ibm.academia.apirest.repository.PasionTarjetaRepository;
import com.ibm.academia.apirest.services.impl.PasionTarjetaDAOImpl;

public class PasionTarjetaDAOImplTest {
	
	PasionTarjetaDAO pasionTarjetaDao;
	PasionTarjetaRepository pasionTarjetaRepository;
	
	void setUp() {
		
		pasionTarjetaRepository = mock(PasionTarjetaRepository.class);
		pasionTarjetaDao = new PasionTarjetaDAOImpl(pasionTarjetaRepository);
		
	}
	
	/*@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Buscar tarjeta por pasion, sueldo y edad")
	void findByPasionSueldoEdadTarjeta() {
		String nombrePasion = "Shopping";
		Integer sueldo =10000;
		Integer edad = 25;
		when( pasionTarjetaRepository.findByPasionSueldoEdadTarjeta(nombrePasion, sueldo, edad))
		        .thenReturn((Iterable<PasionTarjeta>) DatosDummy.tarjeta01());
	    //When
		Iterable<PasionTarjeta> expected = pasionTarjetaDao.findByPasionSueldoEdadTarjeta(nombrePasion, sueldo, edad);
		
		//then
		
		assertThat(expected.equals(DatosDummy.tarjeta01().getNombrePasion())));
		

		verify(pasionTarjetaRepository)..findByPasionSueldoEdadTarjeta(nombrePasion, sueldo, edad);
		
	}*/

}
