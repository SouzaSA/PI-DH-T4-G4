package com.pi.dh.dto;

import java.io.Serializable;

import com.pi.dh.domain.model.enums.Departamentos;

import lombok.Data;

@Data
public class SalaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long salaId;
	private Departamentos departamento;
	private Integer andar;
	private Integer numero;
	private Integer capacidade;
	
	public String getDepartamento() {
		return departamento.getDescription();
	}

}
