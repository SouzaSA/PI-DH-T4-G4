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

import com.pi.dh.domain.model.enums.Obrigatoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="disciplina")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="disciplina_id")
	private Long disciplinaId;
	
	@Size(max=50)
	@Column
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String ementa;
	
    @Column
    private Integer creditos;
    
    @Size(max=10)
    @Column
    private String codigo;
    
    @Column(name="semestre_ideal")
    private Integer semestreIdeal;
    
    @OneToMany(
			mappedBy = "disciplina",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<DisciplinaOferecida> disciplinasOferecidas;
	
    @OneToMany(
    		mappedBy = "disciplina",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<Requere> disciplinas;
    
    @OneToMany(
			mappedBy = "requerida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<Requere> requeridas;
    
    @OneToMany(
			mappedBy = "disciplinaOferecida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<CursaDisciplinaOferecida> disciplinasOferecidasCursadas;
    
	
	public Disciplina(Long disciplinaId, String nome, String ementa, Integer creditos, 
			String codigo, Integer semestreIdeal, Obrigatoria obrigatoria) {
		super();
		this.disciplinaId = disciplinaId;
		this.nome = nome;
		this.ementa = ementa;
		this.creditos = creditos;
		this.codigo = codigo;
		this.semestreIdeal = semestreIdeal;
	}

}
