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

import lombok.Data;

@Entity
@Table(name="disciplina")
@Data
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
    @JsonManagedReference
	private List<DisciplinaOferecida> disciplinasOferecidas;
	
    @OneToMany(
    		mappedBy = "disciplina",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
    @JsonManagedReference
	private List<Requere> disciplinas;
    
    @OneToMany(
			mappedBy = "requerida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
    @JsonManagedReference
	private List<Requere> requeridas;
    
    @OneToMany(
			mappedBy = "disciplinaOferecida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
    @JsonManagedReference
	private List<CursaDisciplinaOferecida> disciplinasOferecidasCursadas;
    

}
