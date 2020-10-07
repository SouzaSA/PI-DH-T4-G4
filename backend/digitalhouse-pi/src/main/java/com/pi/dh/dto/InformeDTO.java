package com.pi.dh.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pi.dh.domain.model.Informe;
import com.pi.dh.domain.model.enums.Departamentos;
import com.pi.dh.domain.model.enums.PrioridadeInforme;

import lombok.Data;

@Data
public class InformeDTO implements Serializable {
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
	private PrioridadeInforme prioridade;
	
	@Column
	@NotNull
	private Departamentos departamento;
	
	@Column(name="data_publicacao")
	private OffsetDateTime dataPublicacao;
	
	public InformeDTO(Informe obj) {
		
		informeId = obj.getInformeId();
		titulo = obj.getTitulo();
		descricao = obj.getDescricao();
		prioridade = obj.getPrioridade();
		departamento = obj.getDepartamento();
		dataPublicacao = obj.getDataPublicacao();
	}
	
}
