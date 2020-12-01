package com.pi.dh.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name="cursa_disciplina_oferecida")
public class CursaDisciplinaOferecida implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cursa_disciplina_oferecida_id")
	private Long cursaDisciplinaOferecidaId;
	
	@Column(name="data_inscricao")
	private OffsetDateTime dataInscricao;
	
	@Column(name="data_deferimento")
	private OffsetDateTime dataDeferimento;
	
	@Column(name="faltas")
	private Integer faltas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_aluno_id")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="fk_disciplina_oferecida_id")
	private DisciplinaOferecida disciplinaOferecida;
	
	@OneToMany(
			mappedBy = "disciplinaCursadaAluno",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	@JsonManagedReference
	private List<Nota> notas;
	
}
