package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	
}
