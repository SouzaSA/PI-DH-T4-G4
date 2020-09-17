package com.pi.dh.model;

import javax.persistence.Entity;
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
public class Obrigatoria {
	
	@ManyToOne(optional=true)
	private Curso curso;
	
	@ManyToOne(optional=true)
	private Disciplina disciplina;

}
