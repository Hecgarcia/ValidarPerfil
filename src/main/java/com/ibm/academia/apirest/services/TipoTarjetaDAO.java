package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;

public interface TipoTarjetaDAO extends GenericoDAO<TipoTarjeta> {
	
	public TipoTarjeta guardar (TipoTarjeta tipoTarjeta);

}
