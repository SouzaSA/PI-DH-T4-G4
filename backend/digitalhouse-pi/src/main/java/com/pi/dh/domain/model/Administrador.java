package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="administrador")
@Data
public class Administrador  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="administrador_id")
	private Long administradorId;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pessoa_id")
	private Pessoa pessoa;

}
