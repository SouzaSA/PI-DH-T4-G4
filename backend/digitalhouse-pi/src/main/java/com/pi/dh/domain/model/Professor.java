package com.pi.dh.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pi.dh.domain.model.enums.Departamentos;

import lombok.Data;

@Entity
@Table(name="professor")
@Data
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="professor_id")
	private Long professorId;
	
	@Column
	private Integer departamento;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pessoa_id")
	@JsonBackReference
	private Pessoa pessoa;
	
	@OneToMany(
			mappedBy = "professor",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonManagedReference
	private List<DisciplinaOferecida> disciplinaOferecida;
	
	@OneToMany(
			mappedBy = "professor",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JsonManagedReference
	private List<Informe> informes;

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento.getCod();
		
	}
	
	public Departamentos getDepartamento() {
		return Departamentos.toEnum(departamento);
	}
	
}
