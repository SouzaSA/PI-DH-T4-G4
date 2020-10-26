package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long alunoId;
	private PessoaDTO pessoaDTO;
	private CursoDTO cursoDTO;
	
}