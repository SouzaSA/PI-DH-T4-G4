package com.pi.dh.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.pi.dh.domain.model.Endereco;
import com.pi.dh.domain.model.Imagem;
import com.pi.dh.domain.model.Telefone;

import lombok.Data;

@Data
public class PessoaDTO {
	
	private Long pessoaId;
    private OffsetDateTime dataCadastro;	
    private String sobrenome;	
	private String nome;	
	private String email;	
	private String password;	
	private Imagem foto;	
	private List<Telefone> telefone;	
	private Endereco endereco;
	
}