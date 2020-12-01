package com.pi.dh.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="aluno")
@Data
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aluno_id")
	private Long alunoId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonBackReference
    @JoinColumn(name = "fk_pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_curso_id")
	private Curso curso;
	
	@OneToMany(
			mappedBy = "aluno",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	@JsonManagedReference
	private List<CursaDisciplinaOferecida> disciplinasCursadas;
	
}
