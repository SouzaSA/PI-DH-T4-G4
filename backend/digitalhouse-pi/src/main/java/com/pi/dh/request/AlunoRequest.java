package com.pi.dh.request;

import com.pi.dh.domain.model.Curso;

import lombok.Data;

@Data
public class AlunoRequest {

	private Long alunoId;
	private PessoaRequest pessoaRequest;	
	private Curso curso;
	
}
