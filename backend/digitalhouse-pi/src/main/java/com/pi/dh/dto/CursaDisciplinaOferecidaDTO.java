package com.pi.dh.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CursaDisciplinaOferecidaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long cursaDisciplinaOferecida;
	private OffsetDateTime dataInscricao;
	private OffsetDateTime data_deferimento;
	private AlunoDTO aluno;
	private DisciplinaOferecidaDTO disciplinaOferecida;
	private List<NotaDTO> notas;

}
