package com.ibm.academia.apirest.models.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TipoTarjetaDTO {
	
    private Integer id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 4, max = 60)
	private String nombre;

}
