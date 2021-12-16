package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.TipoTarjetaDTO;
import com.ibm.academia.apirest.models.entities.TipoTarjeta;

public class TipoTarjetaMapper {
	
	
	public static TipoTarjetaDTO mapTarjeta(TipoTarjeta tipoTarjeta) {
		
		TipoTarjetaDTO tipoTarjetaDto = new TipoTarjetaDTO();
		
	    tipoTarjetaDto.setId(tipoTarjeta.getId());
	    tipoTarjetaDto.setNombre(tipoTarjeta.getNombre());
	    
	    return tipoTarjetaDto;
	}
	
	

}
