package com.pi.dh.dto;

import java.io.Serializable;

import com.pi.dh.domain.model.enums.Departamentos;

import lombok.Data;

@Data
public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long professorId;
	private PessoaDTO pessoa;
	private Departamentos departamento;
	
	public String getDepartamento() {
		return departamento.getDescription();
	}
}