package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="professor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="professor_id")
	private Long professor_id;
	@Column(length= 40)
	private Long departamento;

	@OneToOne(optional=true)
	private Pessoa pessoa;

}
