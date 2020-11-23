package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;	
}
