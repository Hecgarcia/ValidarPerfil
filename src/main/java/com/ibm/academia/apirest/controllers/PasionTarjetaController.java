package com.ibm.academia.apirest.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.models.entities.PasionTarjeta;
import com.ibm.academia.apirest.services.PasionTarjetaDAO;

@RestController
@RequestMapping("/pasion")
public class PasionTarjetaController {
	
	
	
	@Autowired
	private PasionTarjetaDAO tarjetaDao;
	
	
	@GetMapping("/tarjetas")
	public ResponseEntity<String> findByPasionSueldoEdad(@RequestParam String nombrePasion, 
            @RequestParam Integer sueldo, 
            @RequestParam Integer edad){
		PasionTarjeta tarjeta = null;
		
		if (tarjetaDao.validarDatos(nombrePasion, sueldo, edad)) {
			tarjeta = tarjetaDao.findByPasionSueldoEdad(nombrePasion, sueldo, edad);		
		}else {
			throw new BadRequestException("Lo sentimos por el momento no tenemos tarjeta acorede a su perfil");
		}
		
		
		System.out.println(tarjeta.getTarjetaPasion());
	
		
		return new ResponseEntity<>(tarjeta.getTarjetaPasion(), HttpStatus.OK);
		
	}


	
		
	}
	
	
	

