package com.pi.dh.domain.model;

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
@Table(name="requere")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Requere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="requere_id")
	private Long requereId;
	
	@ManyToOne(optional=true)
	private Disciplina disciplina;
	
	@ManyToOne(optional=true)
	private Disciplina requerida;

}
