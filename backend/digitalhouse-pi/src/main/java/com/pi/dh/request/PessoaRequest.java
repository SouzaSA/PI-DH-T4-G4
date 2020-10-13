package com.pi.dh.request;

import com.pi.dh.domain.model.Endereco;

import lombok.Data;

@Data
public class PessoaRequest {

	private Long pessoaId;
    private String sobrenome;
	private String nome;
	private String email;
	private String password;
	private String foto;
	private Endereco endereco;
	
}
