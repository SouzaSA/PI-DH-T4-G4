package com.pi.dh.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pi.dh.domain.model.CursaDisciplinaOferecida;
import com.pi.dh.domain.model.enums.Avaliacoes;

import lombok.Data;

@Data
public class NotaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long notaId;
	private Avaliacoes titulo;
	private Integer numero;
	private BigDecimal valor;
	private CursaDisciplinaOferecida disciplinaCursadaAluno;
	
}