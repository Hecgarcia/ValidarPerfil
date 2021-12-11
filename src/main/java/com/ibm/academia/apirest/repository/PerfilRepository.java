package com.ibm.academia.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository< Perfil, Integer> {

}
