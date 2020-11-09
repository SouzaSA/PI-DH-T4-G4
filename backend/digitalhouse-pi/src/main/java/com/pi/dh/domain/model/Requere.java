package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="requere")
@Data
public class Requere implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="requere_id")
	private Long requereId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_disciplina_id")
	private Disciplina disciplina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_requerida_id")
	private Disciplina requerida;

}
