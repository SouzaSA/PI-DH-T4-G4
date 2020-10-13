package com.pi.dh.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.ManyToOne;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.model.enums.Avaliacoes;

import lombok.Data;

@Data
public class NotaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long notaId;
	private Avaliacoes titulo;
	private BigDecimal valor;
	
	@ManyToOne
	private CursaDisciplinaOferecida disciplinaCursadaAluno;
}
