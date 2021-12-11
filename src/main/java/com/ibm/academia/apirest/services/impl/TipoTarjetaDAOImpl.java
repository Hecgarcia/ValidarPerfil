package com.ibm.academia.apirest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;
import com.ibm.academia.apirest.repository.TipoTarjetaRepository;
import com.ibm.academia.apirest.services.TipoTarjetaDAO;

@Service
public class TipoTarjetaDAOImpl extends GenericoDAOImpl<TipoTarjeta, TipoTarjetaRepository> implements TipoTarjetaDAO {

	@Autowired
	private TipoTarjetaRepository tipoTarjetaRepository;
	

	@Override
	@Transactional
	public TipoTarjeta guardar(TipoTarjeta tipoTarjeta) {
		
		return tipoTarjetaRepository.save(tipoTarjeta);
	}
	
	
	public TipoTarjetaDAOImpl(TipoTarjetaRepository repository) {
		super(repository);
		
	}
	
	

}
