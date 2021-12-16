package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;

public interface shoppingDAO  {
	
	public Optional<TipoTarjeta> buscarPorId(Integer TarjetaId);

}
