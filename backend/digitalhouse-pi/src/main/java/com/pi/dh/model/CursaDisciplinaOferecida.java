package com.pi.dh.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cursa_disciplina_oferecida")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursaDisciplinaOferecida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cursa_disciplina_oferecida_id")
	private Long cursaDisciplinaOferecida;
	@Column(name="data_inscricao")
	private Timestamp dataInscricao;
	@Column(name="data_deferimento")
	private Timestamp data_deferimento;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private DisciplinaOferecida disciplinaOferecida;
	
	@OneToMany
	private Nota nota;
	
}