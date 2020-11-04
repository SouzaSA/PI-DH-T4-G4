package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProfessorRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long professorId;
	private PessoaRequest pessoa;	
	private Integer departamento;
	
}