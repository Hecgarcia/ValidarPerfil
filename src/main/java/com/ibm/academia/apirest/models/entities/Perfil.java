package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "perfiles", schema = "validar_perfil")
public class Perfil implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 4, max = 60)
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"perfiles"})
	private Set<Cliente> cliente;
	
	
	
	public Perfil(Integer id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}
	
		
	@PrePersist
	private void antesPersistir() {
		this.fechaAlta = new Date();
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date();
	}




	private static final long serialVersionUID = 1L;

	
}
