package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="sala")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sala_id")
	private Long salaId;
	
	@Size(max = 40)
	@Column
	private Long departamento;
	
	@Column
	private Integer andar;
	
	@Column
	private Integer numero;
	
	@Column
	private Integer capacidade;
}
