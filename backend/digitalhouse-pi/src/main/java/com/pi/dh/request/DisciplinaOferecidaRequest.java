package com.pi.dh.request;

import java.io.Serializable;

import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;

import lombok.Data;

@Data
public class DisciplinaOferecidaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long disciplinaOferecidaId;
	private String horario;
	private String diaSemana;
	private Integer semestre;
	private Short ano;
	private Integer turma;
	private ProfessorRequest professor;
	private DisciplinaRequest disciplina;
    private SalaRequest sala;

}
