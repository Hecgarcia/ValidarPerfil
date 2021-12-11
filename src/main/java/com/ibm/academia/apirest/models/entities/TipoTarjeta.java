package com.ibm.academia.apirest.models.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tipo_tarjetas", schema = "validar_perfil")

public class TipoTarjeta implements Serializable {
	
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
		
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tipo_tarjeta_perfiles",schema = "validar_perfil",
			joinColumns = @JoinColumn(name = "tipo_tarjetas_id"),
			inverseJoinColumns = @JoinColumn(name = "perfil_id")
			)
	@JsonIgnoreProperties({"tipo_tarjwtas"})
	private Set<Perfil> perfil;
	
	public TipoTarjeta(Integer id, String nombre, BigDecimal rangoMinimo, BigDecimal rangoMaximo, Set<Perfil> perfil) {
		
		this.id = id;
		this.nombre = nombre;
		this.perfil = perfil;
	}

	
	
	
	@PrePersist
	private void antesPersistir() {
		this.fechaAlta = new Date();
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date();
	}
	
	
	
	private static final long serialVersionUID = -5352634857743729019L;
	

}
