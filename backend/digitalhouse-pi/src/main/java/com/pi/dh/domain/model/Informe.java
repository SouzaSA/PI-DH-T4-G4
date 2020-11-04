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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="informe")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
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

	public Informe(Long informeId, String titulo, String descricao, Professor professor, PrioridadeInforme prioridade, Departamentos departamento) {
		super();
		this.informeId = informeId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.professor = professor;
		this.prioridade = prioridade.getCod();
		this.departamento = departamento.getCod();

	}
	
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
