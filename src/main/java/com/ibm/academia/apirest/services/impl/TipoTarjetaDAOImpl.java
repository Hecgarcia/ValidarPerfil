package com.ibm.academia.apirest.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;
import com.ibm.academia.apirest.repository.TipoTarjetaRepository;
import com.ibm.academia.apirest.services.TipoTarjetaDAO;

@Service
public class TipoTarjetaDAOImpl extends GenericoDAOImpl<TipoTarjeta, TipoTarjetaRepository> implements TipoTarjetaDAO {

	@Autowired
	public TipoTarjetaDAOImpl(TipoTarjetaRepository repository) {
		super(repository);
		
	}
	

	@Override
	@Transactional
	public TipoTarjeta guardar(TipoTarjeta tipoTarjeta) {
		
		return repository.save(tipoTarjeta);
	}
	
	
	@Override
	@Transactional (readOnly = true)
	public Optional<TipoTarjeta> buscarPorId(Integer id) {
		
		return repository.findById(id);
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<TipoTarjeta> buscarTodos(){
		
		return repository.findAll();
	}
}
