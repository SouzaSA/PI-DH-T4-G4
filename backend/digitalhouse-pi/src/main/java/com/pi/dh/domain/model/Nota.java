package com.pi.dh.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

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

import com.pi.dh.domain.model.enums.Avaliacoes;

import lombok.Data;

@Entity
@Table(name="nota")
@Data
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nota_id")
	private Long notaId;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Avaliacoes titulo;
	
	@Column(precision=5, scale=2)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_cursa_disciplina_oferecida_id")
	private CursaDisciplinaOferecida disciplinaCursadaAluno;
	
}
