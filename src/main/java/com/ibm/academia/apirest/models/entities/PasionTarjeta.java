package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pasion_tarjetas", schema = "validar_perfil")
public class PasionTarjeta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "El nombre no puede ser nulo")
	@NotEmpty(message = "El nombre no puede ser vacio")
	@Size(min = 4, max = 80)
	@Column(name = "nombre_pasion")
	private String nombrePasion;
	
	@Positive(message = "El valor debe ser mayor a cero")
	@Column(name = "sueldo_minimo", nullable = false)
	private Integer sueldoMinimo;
	
	@Positive(message = "El valor debe ser mayor a cero")
	@Column(name = "sueldo_maximo", nullable = false)
	private Integer sueldoMaximo;
	
	@Positive(message = "El valor debe ser mayor a cero")
	@Column(name = "edad_minima", nullable = false)
	private Integer edadMinima;
	
	@Positive(message = "El valor debe ser mayor a cero")
	@Column(name = "edad_maxima", nullable = false)
	private Integer edadMaxima;
	
	@Column(name = "tarjetas_pasion", nullable = false)
	private String tarjetaPasion;
		
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	public PasionTarjeta( String nombrePasion, Integer sueldoMinimo,Integer sueldoMaximo, Integer edadMinima, Integer edadMaxima, String tarjetaPasion) {
		
		this.nombrePasion = nombrePasion;
		this.sueldoMinimo = sueldoMinimo;
		this.sueldoMaximo = sueldoMaximo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.tarjetaPasion = tarjetaPasion;
	}




	@Override
	public int hashCode() {
		return Objects.hash(edadMaxima, edadMinima, id, nombrePasion, sueldoMaximo, sueldoMinimo, tarjetaPasion);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasionTarjeta other = (PasionTarjeta) obj;
		return Objects.equals(edadMaxima, other.edadMaxima) && Objects.equals(edadMinima, other.edadMinima)
				&& Objects.equals(id, other.id) && Objects.equals(nombrePasion, other.nombrePasion)
				&& Objects.equals(sueldoMaximo, other.sueldoMaximo) && Objects.equals(sueldoMinimo, other.sueldoMinimo)
				&& Objects.equals(tarjetaPasion, other.tarjetaPasion);
	}











	private static final long serialVersionUID = 3227819321574535519L;

}
