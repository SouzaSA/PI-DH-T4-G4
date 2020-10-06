package com.pi.dh.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	public String cep;
	public String rua;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
}
