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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="curso")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curso_id")
	private Long cursoId;
	
	@Size(max=30)
	@Column
	private String nome;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_professor_id")
	private Professor professor;
	
	@OneToMany(
			mappedBy = "curso",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<Aluno> alunos;

}
