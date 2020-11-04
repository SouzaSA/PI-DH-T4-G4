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

import com.pi.dh.domain.model.enums.Departamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="professor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="professor_id")
	private Long professor_id;
	
	@Column
	private Integer departamento;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pessoa_id")
	private Pessoa pessoa;
	
	@OneToMany(
			mappedBy = "professor",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<DisciplinaOferecida> disciplinaOferecida;
	
	@OneToMany(
			mappedBy = "professor",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Informe> informes;

	public Professor(Long professor_id, Pessoa pessoa, Departamentos departamento) {
		super();
		this.professor_id = professor_id;
		this.pessoa = pessoa;
		this.departamento = departamento.getCod();

	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento.getCod();
		
	}
	
	public Departamentos getDepartamento() {
		return Departamentos.toEnum(departamento);
	}
	
}
