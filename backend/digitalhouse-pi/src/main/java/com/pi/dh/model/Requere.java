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
@Table(name="requere")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Requere {
	
	@ManyToOne(optional=true)
	private Disciplina disciplina;
	
	@ManyToOne(optional=true)
	private Disciplina requerida;

}
