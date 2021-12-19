package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.PasionTarjeta;
import com.ibm.academia.apirest.repository.PasionTarjetaRepository;

@DataJpaTest
public class PasionTarjetaRepositoryTest {
	
	@Autowired
	private PasionTarjetaRepository tarjetaRepository;
	
	@BeforeEach
	void setUp() {
		
		//given
		
		tarjetaRepository.save(DatosDummy.tarjeta01());
		tarjetaRepository.save(DatosDummy.tarjeta02());
		tarjetaRepository.save(DatosDummy.tarjeta03());
		tarjetaRepository.save(DatosDummy.tarjeta04());
		tarjetaRepository.save(DatosDummy.tarjeta05());
		tarjetaRepository.save(DatosDummy.tarjeta06());
		tarjetaRepository.save(DatosDummy.tarjeta07());
		tarjetaRepository.save(DatosDummy.tarjeta08());
		tarjetaRepository.save(DatosDummy.tarjeta09());
		tarjetaRepository.save(DatosDummy.tarjeta10());
			
	}
	
	@AfterEach
	void tearDown()	{
		tarjetaRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Busca Tarjeta")
	void findByPasionSueldoEdadTarjeta() {
		
		//When
		String nombrePasion = "Shopping";
		Integer sueldo =1000;
		Integer edad = 25;
		
		List<PasionTarjeta> expected = (List<PasionTarjeta>)tarjetaRepository.findByPasionSueldoEdadTarjeta(nombrePasion, sueldo, edad);
		
		//Then
		assertThat(expected.size()).isEqualTo(1);
	}
	
	
	
}
