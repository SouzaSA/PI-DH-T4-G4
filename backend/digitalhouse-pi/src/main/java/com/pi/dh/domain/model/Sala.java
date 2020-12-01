package com.pi.dh.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pi.dh.domain.model.enums.Departamentos;

import lombok.Data;

@Entity
@Table(name="sala")
@Data
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sala_id")
	private Long salaId;
	
	@Size(max = 40)
	@Column
	private Departamentos departamento;
	
	@Column
	private Integer andar;
	
	@Column
	private Integer numero;
	
	@Column
	private Integer capacidade;
	
	@OneToMany(
			mappedBy = "sala",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonManagedReference
	private List<DisciplinaOferecida> disciplinasOferecidas;
	
}
