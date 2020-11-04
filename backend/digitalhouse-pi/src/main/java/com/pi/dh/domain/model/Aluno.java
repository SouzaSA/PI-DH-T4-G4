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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="aluno")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aluno_id")
	private Long alunoId;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_curso_id")
	private Curso curso;
	
	@OneToMany(
			mappedBy = "aluno",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<CursaDisciplinaOferecida> disciplinasCursadas;
	
}
