package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; 
	
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	
}