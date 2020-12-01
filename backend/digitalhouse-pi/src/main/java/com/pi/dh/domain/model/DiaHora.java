package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;

import lombok.Data;

@Data
@Entity
@Table(name="dia_hora")
public class DiaHora implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dia_hora_id")
	private Long diaHoraId;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Hora horario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="dia_semana")
	private DiaSemana diaSemana;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_disciplina_oferecida_id")
	private DisciplinaOferecida disciplinaOferecida;

}
