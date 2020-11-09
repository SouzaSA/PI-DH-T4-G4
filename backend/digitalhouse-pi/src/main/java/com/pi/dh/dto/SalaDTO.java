package com.pi.dh.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SalaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long salaId;
	private String departamento;
	private Integer andar;
	private Integer numero;
	private Integer capacidade;
	//private List<DisciplinaOferecidaDTO> disciplinasOferecidas;

}
