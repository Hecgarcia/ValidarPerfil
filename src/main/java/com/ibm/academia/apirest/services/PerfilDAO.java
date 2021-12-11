package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Perfil;

public interface PerfilDAO extends GenericoDAO<Perfil> {
	
	
	
	public Perfil guardar (Perfil perfil);
	

}
