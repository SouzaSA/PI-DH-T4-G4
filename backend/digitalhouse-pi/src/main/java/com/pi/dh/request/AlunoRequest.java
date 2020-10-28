package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlunoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long alunoId;
	private PessoaRequest pessoaRequest;	
	private CursoRequest curso;
	
}
