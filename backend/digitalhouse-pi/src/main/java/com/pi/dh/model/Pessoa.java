package com.pi.dh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="pessoa")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pessoa_id")
	private Long pessoaId;
	@Column(length = 8)
    private String cep;
	@Column(length = 60)
    private String rua;
	@Column
    private Long numero;
	@Column(length = 40)
    private String bairro;
	@Column(length = 40)
	private String cidade;
	@Column(length = 25)
    private String estado;
	@Column(length = 60)
    private String complemento;
	@Column(name="data_cadastro")
    private Date dataCadastro;
	@Column(length = 60)
    private String sobrenome;
	@Column(length = 25)
	private String nome;
	@Column(length = 60)
	private String email;
	@Column(length = 256)
	private String password;
	@Column(length = 256)
	private String foto;
	
	@OneToMany
	private Telefone telefone;

}
