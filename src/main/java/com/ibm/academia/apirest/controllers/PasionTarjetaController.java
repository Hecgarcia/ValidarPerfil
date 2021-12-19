package com.ibm.academia.apirest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.models.entities.PasionTarjeta;
import com.ibm.academia.apirest.services.PasionTarjetaDAO;

@RestController
@RequestMapping("/pasion")
public class PasionTarjetaController {
		
	Logger logger = LoggerFactory.getLogger(PasionTarjetaController.class);
	
	@Autowired
	private PasionTarjetaDAO tarjetaDao;
	
	/**
	 * EndPoint para listar dettalle de las tarjetas por pasión sueldo y rango de edad 
	 * @param nombrePasion nombre el cual incluye los datos de las pasiones
	 * @param sueldo rango de sueldi acorede al requeimiento minino
	 * @param edad debe ser mayor de edad
	 * @return lista de tarjetas con los detallles del perfil rengo edad y suelddo
	 * @author Hector Garcia 19-12-2021 
	 */
	@GetMapping("/tarjetas")
	public ResponseEntity<?> findByPasionSueldoEdad(@RequestParam String nombrePasion, 
            @RequestParam Integer sueldo, 
            @RequestParam Integer edad){
		List<PasionTarjeta> tarjetaCompleta = null;
	
		try {
			tarjetaCompleta = (List<PasionTarjeta>) tarjetaDao.findByPasionSueldoEdad(nombrePasion, sueldo, edad);
		}
		
		catch (NullPointerException p) {
			logger.error(" datos incorrrecto "+p.getMessage());						
		}
		
		return new ResponseEntity<List<PasionTarjeta>>(tarjetaCompleta, HttpStatus.OK);
		
  }
	
	/**
	 * EndPoint para listar  las tarjetas acorde añ perfil de los parametros 
	 * @param nombrePasion nombre el cual incluye los datos de las pasiones
	 * @param sueldo rango de sueldi acorede al requeimiento minino
	 * @param edad debe ser mayor de edad
	 * @return lista de tarjetas con los detallles del perfil rengo edad y suelddo
	 * @author Hector Garcia 19-12-2021
	 */
	@GetMapping("/opcion/tarjetas")
	public ResponseEntity<?> findByPasionSueldoEdadTarjeta(
			@RequestParam String nombrePasion, 
            @RequestParam Integer sueldo, 
            @RequestParam Integer edad){
         List<PasionTarjeta> tarjetas = null;
            try {
                  tarjetas = (List<PasionTarjeta>) tarjetaDao.findByPasionSueldoEdadTarjeta(nombrePasion, sueldo, edad);
           
           
            }  catch (NullPointerException e) {
           logger.error(" no cumplem perfil "+e.getMessage());
    }

             return new ResponseEntity<List<PasionTarjeta>>(tarjetas, HttpStatus.OK); 

     }
			
 }
	
