package com.ibm.academia.apirest.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.TipoTarjeta;
import com.ibm.academia.apirest.repository.ShoppingRepository;
import com.ibm.academia.apirest.services.shoppingDAO;

@Service
public class shoppingDAOImpl implements shoppingDAO {

	@Autowired
	private ShoppingRepository shoppingRepository;
	
	@Override
	public Optional<TipoTarjeta> buscarPorId(Integer tarjetaid) {
		
		return shoppingRepository.findById(tarjetaid) ;
	}

}
