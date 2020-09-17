package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="disciplina")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="disciplina_id")
	private Long disciplinaId;
	@Column(length=50)
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String ementa;
    @Column
    private Integer creditos;
    @Column(length=10)
    private String codigo;
    @Column(name="semestre_ideal")
    private Integer semestreIdeal;

}
