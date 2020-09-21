package com.pi.dh.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class newPessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String cep;
    private String rua;
    private Long numero;
    private String bairro;
	private String cidade;
    private String estado;
    private String complemento;
    private String sobrenome;
	private String nome;
	private String email;
	private String password;
	private String foto;
	
	private String telefone1;
	private String telefone2;
	
	
}
