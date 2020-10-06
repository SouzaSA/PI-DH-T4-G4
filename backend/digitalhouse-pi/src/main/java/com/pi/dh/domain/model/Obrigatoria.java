package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="obrigatoria")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Obrigatoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="obrigatoria_id")
	private Long obrigatoriaId;
	
	@ManyToOne(optional=true)
	private Curso curso;
	
	@ManyToOne(optional=true)
	private Disciplina disciplina;

}
