package com.pi.dh.model;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
	
	@Size(max = 8)
	@Column
    private String cep;
	
	@Size(max = 60)
	@Column
    private String rua;
	
	@Size(max = 40)
	@Column
    private Long numero;
	
	@Size(max = 40)
	@Column
    private String bairro;
	
	@Size(max = 40)
	@Column
	private String cidade;
	
	@Size(max = 25)
	@Column
    private String estado;
	
	@Size(max = 60)
	@Column
    private String complemento;
	
	
	@Column(name="data_cadastro")
    private OffsetDateTime dataCadastro;
	
	@Size(max = 60)
	@Column
    private String sobrenome;
	
	@Size(max = 25)
	@Column
	private String nome;
	
	@Size(max = 60)
	@Column
	private String email;
	
	@Size(max = 256)
	@Column
	private String password;
	
	@Size(max = 256)
	@Column
	private String foto;
	
	@OneToMany
	@JoinColumn(name = "telefone_id")
	private List<Telefone> telefone;

}
