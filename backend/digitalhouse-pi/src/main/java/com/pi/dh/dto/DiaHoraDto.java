package com.pi.dh.dto;

import java.util.List;

import com.pi.dh.domain.model.Aluno;
import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;

import lombok.Data;

@Data
public class DiaHoraDto {
	
	private Long diaHoraId;
	private Hora horario;
	private DiaSemana diaSemana;
	private List<Aluno> alunos;
	
	public String getHorario() {
    	return horario.getHora();
    }
    
    public String getDiaSemana() {
    	return diaSemana.getDia();
    }

}
