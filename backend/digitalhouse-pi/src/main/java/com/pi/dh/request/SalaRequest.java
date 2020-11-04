package com.pi.dh.request;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SalaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long salaId;
	private String departamento;
	private Integer andar;
	private Integer numero;
	private Integer capacidade;
	private List<DisciplinaOferecidaRequest> disciplinasOferecidas;

}
