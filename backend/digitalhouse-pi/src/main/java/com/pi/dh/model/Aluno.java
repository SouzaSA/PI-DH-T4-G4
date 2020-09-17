package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aluno_id")
	private Long alunoId;

	@OneToOne(optional=true)
	private Pessoa pessoa;
	
	@ManyToOne(optional=true)
	private Curso curso;
	
}
