package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long cursoId;
	private String nome;
	
}