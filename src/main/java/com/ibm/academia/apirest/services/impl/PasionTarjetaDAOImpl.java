package com.ibm.academia.apirest.services.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.PasionTarjeta;
import com.ibm.academia.apirest.repository.PasionTarjetaRepository;
import com.ibm.academia.apirest.services.PasionTarjetaDAO;

@Service
public class PasionTarjetaDAOImpl extends GenericoDAOImpl<PasionTarjeta, PasionTarjetaRepository> implements PasionTarjetaDAO {

	
	@Autowired
	public PasionTarjetaDAOImpl(PasionTarjetaRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional(readOnly = true)
	public PasionTarjeta findByPasionSueldoEdad(String nombrePasion, Integer sueldo, Integer edad) {
		
		return repository.findByPasionSueldoEdad(nombrePasion, sueldo, edad);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Boolean validarDatos(String nombrePasion, Integer sueldo, Integer edad) {
		Boolean resp = false;
		try {
			if(edad<18 || edad>75)
				throw new BadRequestException("Debe de ser mayor de 18 o menor de 75 años");
			else{
				if (nombrePasion.equals("Shopping") || nombrePasion.equals("Travels") || nombrePasion.equals("Help")
				    || nombrePasion.equals("My Business") || nombrePasion.equals("Sports") || nombrePasion.equals("My Style")){
					
					if(sueldo >=7000 || sueldo<=1000000) {
						resp = true;
					}else {
						throw new BadRequestException("El suledo minimo requerido es de 7000");
					}
						
					
				}else {
					throw new BadRequestException("E l nombre de pasion no existe ");
				}
			}
			
		}
		catch(NotFoundException e){
			System.out.print(e.toString());
		}
		
		
		return resp;
		
	}

	
	
		
	

}
