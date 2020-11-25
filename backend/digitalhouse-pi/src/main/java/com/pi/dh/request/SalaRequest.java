package com.pi.dh.request;

import java.io.Serializable;

import com.pi.dh.domain.model.enums.Departamentos;

import lombok.Data;

@Data
public class SalaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long salaId;
	private Integer departamento;
	private Integer andar;
	private Integer numero;
	private Integer capacidade;

}
