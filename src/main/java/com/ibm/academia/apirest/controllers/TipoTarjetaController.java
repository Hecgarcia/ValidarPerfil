package com.ibm.academia.apirest.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.BadRequestException;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;
import com.ibm.academia.apirest.services.TipoTarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TipoTarjetaController {
	
	@Autowired
	private TipoTarjetaDAO tipoTarjetaDao;
	
	 /**
	  * 
	  * @param pasion
	  * @param salario
	  * @param edad
	  * @param tarjetaId
	  * @return
	  */
	 @GetMapping("/id/tarjeta")
		public TipoTarjeta  buscartarjetaPorPerfil(
				@RequestParam (value = "pasion") String pasion,
				@RequestParam (value = "salario") BigDecimal salario,
				@RequestParam (value =  "edad") Integer edad,
				@RequestParam (value = "tarjetaId") Integer tarjetaId
				
				) {
			
			TipoTarjeta tarjeta = tipoTarjetaDao.buscarPorId(tarjetaId).orElse(null);
			if(tarjeta == null)
				throw new BadRequestException(String.format("La tarjeta con ID; %d no existe en la BD", tarjetaId));
			
			return tarjeta;
			
		} 
	
	   
	   /**
	    * EndPoint para obtener las tarjetas
	    * @return lista de tarjetas
	    * @author Hector Garcia 11-12-2021
	    */
	   @GetMapping("/lista/tarjetas")
		public List<TipoTarjeta> buscarTodas(){
			
			List<TipoTarjeta> tarjetas = (List<TipoTarjeta>) tipoTarjetaDao.buscarTodos();
			if(tarjetas.isEmpty())
				throw new BadRequestException("No existen tarjetas en la Base de Datos");
			
			return tarjetas;
		 }
	    
	    
	    /**
	     * Endpoint para obtener tarjeta por ID
	     * @param tarjetaId
	     * @return la tarjeta por id si existiese
	     * @author Hector Garcia E. 11-12-2021
	     */
	    @GetMapping("/id/{tarjetaId}")
		public TipoTarjeta  buscartarjetaPorId(@PathVariable Integer tarjetaId) {
			
			TipoTarjeta tarjeta = tipoTarjetaDao.buscarPorId(tarjetaId).orElse(null);
			if(tarjeta == null)
				throw new BadRequestException(String.format("La tarjeta con ID; %d no existe en la BD", tarjetaId));
			
			return tarjeta;
			
		} 
	
	
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
