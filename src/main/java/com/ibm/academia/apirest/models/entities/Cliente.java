package com.ibm.academia.apirest.models.entities;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.Estatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes", schema = "validar_perfil")
@PrimaryKeyJoinColumn(name = "persona_id")

public class Cliente extends Persona {

		

	@Column(name = "fecha_nacimiento")
	private Date    fechaNacimiento;
	
	@Column(name = "sueldo")
	private BigDecimal sueldo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cliente_perfiles", schema = "validar_perfil",
			   joinColumns = @JoinColumn(name = "cliente_id"),
			   inverseJoinColumns = @JoinColumn(name = "perfil_id")
	)
	@JsonIgnoreProperties({"clientes"})
	private Set<Perfil> perfil;

	@Column(name = "estatus")
	@Enumerated(EnumType.STRING)
	private Estatus estatus;
	 
	
		
	public Cliente(Integer id, String nombre, String apellido, Direccion direccion, Date fechaNacimiento,
			BigDecimal sueldo, Set<Perfil> perfil, Estatus estatus) {
		super(id, nombre, apellido, direccion);
	
	}
	
	

	@Override
	public String toString() {
		return super.toString()+ "\tCliente []";
	}



	private static final long serialVersionUID = 4179462323752445504L;


}



