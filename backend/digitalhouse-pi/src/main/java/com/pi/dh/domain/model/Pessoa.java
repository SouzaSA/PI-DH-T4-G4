package com.pi.dh.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pessoa_id")
	private Long pessoaId;
	
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
	@JoinColumn(name = "pessoa_id")
	private List<Telefone> telefone;
	
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	

}
