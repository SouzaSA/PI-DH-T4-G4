package com.pi.dh.request;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;



import lombok.Data;

@Data
public class CursaDisciplinaOferecidaRequest  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long cursaDisciplinaOferecidaId;
	private OffsetDateTime dataInscricao;
	private OffsetDateTime data_deferimento;
	private Integer faltas;
	private AlunoRequest aluno;
	private DisciplinaOferecidaRequest disciplinaOferecida;
	private List<NotaRequest> notas;

}
