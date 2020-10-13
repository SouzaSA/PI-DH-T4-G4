package com.pi.dh.request;

import java.io.Serializable;

import com.pi.dh.domain.model.Endereco;

import lombok.Data;

@Data
public class PessoaRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long pessoaId;
    private String sobrenome;
	private String nome;
	private String email;
	private String password;
	private String foto;
	private Endereco endereco;
	
}
