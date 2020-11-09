package com.pi.dh.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="pessoa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
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
	
	@Column
	private String foto;
	
	@OneToMany(
			mappedBy = "fkPessoaId",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Telefone> telefone;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_endereco_id")
    private Endereco endereco;
	
	@OneToOne(
			mappedBy = "pessoa", 
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, 
            optional = false
    )
	private Administrador administrador;
	
	@OneToOne(
			mappedBy = "pessoa", 
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, 
            optional = false
    )
	private Aluno aluno;
	
	@OneToOne(
			mappedBy = "pessoa", 
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, 
            optional = false
    )
	private Professor professor;
	
	@ManyToMany
	@JoinTable(
		name = "usuario_grupo", 
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "grupo_id")
	)
	private Set<Grupo> grupos = new HashSet<>();

	

}
