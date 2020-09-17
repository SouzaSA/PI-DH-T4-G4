package com.pi.dh.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pi.dh.repository.DiaSemana;
import com.pi.dh.repository.Hora;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="disciplina_oferecida")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class DisciplinaOferecida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="disciplina_oferecida_id")
	private Long disciplinaOferecidaId;
	@Column
	private Enum<Hora> horario;
	@Column(name="dia_semana")
	private Enum<DiaSemana> diaSemana;
	@Column
	private Integer semestre;
	@Column
	private Year ano;
	@Column
	private Integer turma;
	
	@ManyToOne
	private Professor professor;
	
	@ManyToOne
	private Disciplina disciplina;
	
    @ManyToOne
    private Sala sala;

}
