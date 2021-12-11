package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;
import com.ibm.academia.apirest.services.TipoTarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TipoTarjetaController {
	
	@Autowired
	private TipoTarjetaDAO tipoTarjetaDao;
	
	/**
	 * EndPoint para dar de alta unobjeto de tipo TipoTarjetas
	 * @param perfil se ingresa el campo obligatorio
	 * @param result registro de dato exitoso
	 * @return lista de errorees segun el error
	 * @author Hector Garcia 11-12-2021
	 */
	@PostMapping
	public ResponseEntity<?> guardarTipoTarjeta (@Valid @RequestBody TipoTarjeta tipoTarjeta, BindingResult result) {
		
		Map<String, Object > validaciones = new HashMap<String, Object>();
		
		if (result.hasErrors()) {
			
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + " ' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
			
		}
		
		TipoTarjeta tipoTarjetaGuardada = tipoTarjetaDao.guardar(tipoTarjeta);
		
		return new ResponseEntity<TipoTarjeta>(tipoTarjetaGuardada, HttpStatus.CREATED);
		
	}

}
