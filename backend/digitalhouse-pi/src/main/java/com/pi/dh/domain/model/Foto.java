package com.pi.dh.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="fotos")
public class Foto {

	@Id
	@Column(name = "pessoa_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Pessoa pessoa;
	
	private String nomeArquivo;
	private String contentType;
	private Long tamanho;
}
