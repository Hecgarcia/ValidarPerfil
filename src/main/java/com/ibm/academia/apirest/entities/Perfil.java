package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


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
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToMany
	private Set<Cliente> cliente;
	
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Set<TipoTarjeta> tipoTarjeta;*/
	
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
