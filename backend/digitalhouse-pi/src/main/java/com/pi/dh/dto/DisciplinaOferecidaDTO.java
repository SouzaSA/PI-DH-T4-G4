package com.pi.dh.dto;

import java.io.Serializable;

import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;

import lombok.Data;

@Data
public class DisciplinaOferecidaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long disciplinaOferecidaId;
	private Hora horario;
	private DiaSemana diaSemana;
	private Integer semestre;
	private Short ano;
	private Integer turma;
	private ProfessorDTO professor;
	private DisciplinaDTO disciplina;
    private SalaDTO sala;
    
}
