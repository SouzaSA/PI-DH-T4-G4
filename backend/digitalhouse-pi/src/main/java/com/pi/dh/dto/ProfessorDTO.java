package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long professorId;
	private PessoaDTO pessoaDTO;
	
}