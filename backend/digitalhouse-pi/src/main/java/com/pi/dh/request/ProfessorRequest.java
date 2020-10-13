package com.pi.dh.request;

import lombok.Data;

@Data
public class ProfessorRequest {

	private Long professorId;
	private PessoaRequest pessoaRequest;	
	private Integer departamento;
	
}