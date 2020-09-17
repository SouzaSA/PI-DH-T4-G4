package com.pi.dh.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column(length=30)
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@Column
	private Integer prioridade;
	@Column(length= 40)
	private Long departamento;
	@Column
	private Timestamp publicacao;
	
	@ManyToOne(optional=true)
	private Professor professor;
	
	@OneToMany
	private Foto foto;
}
