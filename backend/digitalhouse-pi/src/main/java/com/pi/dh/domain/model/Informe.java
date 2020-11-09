package com.pi.dh.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.model.enums.PrioridadeInforme;

import lombok.Data;

@Entity
@Table(name="informe")
@Data
public class Informe implements Serializable {
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="informe_id")
	private Long informeId;
	
	@Size(max=30)
	@Column
	private String titulo;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Column
	@NotNull
	private Integer prioridade;
	
	@Column
	@NotNull
	private Integer departamento;
	
	@Column(name="data_publicacao")
	private OffsetDateTime dataPublicacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_professor_id")
	private Professor professor;
	
	public void setPrioridade(PrioridadeInforme prioridade) {
		this.prioridade = prioridade.getCod();
		
	}
	
	public PrioridadeInforme getPrioridade() {
		return PrioridadeInforme.toEnum(prioridade);
	}
	
	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento.getCod();
		
	}
	
	public Departamentos getDepartamento() {
		return Departamentos.toEnum(departamento);
	}
	

}
