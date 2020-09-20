package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="informe")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Informe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="informe_id")
	private Long informeId;
	
	@Size(max=30)
	@Column
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@Column
	private Integer prioridade;
	
	@Size(max = 20)
	@Column
	private Long departamento;
	
	@Column(name="data_publicacao")
	private String dataPublicacao;
	
	@ManyToOne(optional=true)
	private Professor professor;

}
