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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cursa_disciplina_oferecida")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursaDisciplinaOferecida implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cursa_disciplina_oferecida_id")
	private Long cursaDisciplinaOferecida;
	
	@Column(name="data_inscricao")
	private OffsetDateTime dataInscricao;
	
	@Column(name="data_deferimento")
	private OffsetDateTime data_deferimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_aluno_id")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_disciplina_oferecida_id")
	private DisciplinaOferecida disciplinaOferecida;
	
	@OneToMany(
			mappedBy = "disciplinaCursadaAluno",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<Nota> notas;
	
}
