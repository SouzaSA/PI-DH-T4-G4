package com.pi.dh.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="nota")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
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
	
	@ManyToOne
	private CursaDisciplinaOferecida disciplinaCursadaAluno;
	
}
