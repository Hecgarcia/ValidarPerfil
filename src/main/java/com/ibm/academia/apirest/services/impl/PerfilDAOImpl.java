package com.ibm.academia.apirest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.Perfil;
import com.ibm.academia.apirest.repository.PerfilRepository;
import com.ibm.academia.apirest.services.PerfilDAO;

@Service
public class PerfilDAOImpl extends GenericoDAOImpl<Perfil, PerfilRepository > implements PerfilDAO {

	@Autowired
	private PerfilRepository perfilRepositorio;
	
	
	public Perfil guardar(Perfil perfil) {
	
		return perfilRepositorio.save(perfil);
				
	}
	
	
	public PerfilDAOImpl(PerfilRepository repository) {
		super(repository);
		
	}
	
	

}
