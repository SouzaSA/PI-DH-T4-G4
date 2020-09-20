package com.pi.dh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="foto")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="foto_id")
	private Long fotoId;
	
	@Size(max=256)
	@Column
	private String endereco;
	
	@ManyToOne
	private Informe informe;

}
