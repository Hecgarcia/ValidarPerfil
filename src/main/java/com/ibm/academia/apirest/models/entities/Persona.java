package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "personas", schema = "validar_perfil")
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona implements Serializable {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 60)
	private String  nombre;
	
	@Column(name = "apellido", nullable = false, length = 60)
	private String  apellido;
	
	@Column(name = "curp") 
	private String curp;
	
	
	@Column(name = "fecha_alta")
	private Date    fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date    fechaModificacion;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
			@AttributeOverride(name = "departamento", column = @Column(name = "departamento" )),
	})
	
    private Direccion direccion;
	
	
	
	
	public Persona(Integer id, String nombre, String apellido, Direccion direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}




	@Override
	public int hashCode() {
		return Objects.hash(curp, id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(curp, other.curp) && Objects.equals(id, other.id);
	}
	
	@PrePersist
	private void antesPersistir() {
		this.fechaAlta = new Date();
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date();
	}




	private static final long serialVersionUID = 3239974348149164966L;
	
	
}
