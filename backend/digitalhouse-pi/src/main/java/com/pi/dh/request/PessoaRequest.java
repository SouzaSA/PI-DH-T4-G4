package com.pi.dh.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pi.dh.domain.model.Grupo;

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
	private EnderecoRequest endereco;
	private List<TelefoneRequest> telefones;
	private Set<Grupo> grupos = new HashSet<>();
	
}
