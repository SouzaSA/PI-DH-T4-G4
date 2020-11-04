package com.pi.dh.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pi.dh.domain.model.Grupo;
import com.pi.dh.domain.model.Imagem;

import lombok.Data;

@Data
public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long pessoaId;
    private OffsetDateTime dataCadastro;	
    private String sobrenome;	
	private String nome;	
	private String email;	
	private String password;	
	private Imagem foto;	
	private List<TelefoneDTO> telefone;	
	private EnderecoDTO endereco;
	private Set<Grupo> grupos = new HashSet<>();
	
}