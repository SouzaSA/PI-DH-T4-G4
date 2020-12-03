package com.pi.dh.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class DisciplinaOferecidaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long disciplinaOferecidaId;
	private Integer semestre;
	private Short ano;
	private Integer turma;
	private List<DiaHoraDto> diasHoras;
	private ProfessorDTO professor;
	private DisciplinaDTO disciplina;
    private SalaDTO sala;
    //private List<CursaDisciplinaOferecidaDTO> disciplinasOferecidasCursadas;
    
}
