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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="disciplina_oferecida")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class DisciplinaOferecida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="disciplina_oferecida_id")
	private Long disciplinaOferecidaId;
	
	@Column
	private Integer semestre;
	
	@Column
	private Short ano;
	
	@Column
	private Integer turma;
	
	@OneToMany(
			mappedBy = "disciplinaOferecida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonManagedReference
	private List<DiaHora> diasHoras;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_professor_id")
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_disciplina_id")
	private Disciplina disciplina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_sala_id")
    private Sala sala;
	
	@OneToMany (
			mappedBy = "disciplinaOferecida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonManagedReference
	private List<CursaDisciplinaOferecida> cursaDisciplinasOferecidas;
	

}
