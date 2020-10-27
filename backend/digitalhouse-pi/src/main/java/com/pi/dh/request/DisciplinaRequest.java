package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class DisciplinaRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long disciplinaId;	
	private String nome;	
	private String ementa;	
    private Integer creditos;   
    private String codigo;
    private Integer semestreIdeal;  
	
}