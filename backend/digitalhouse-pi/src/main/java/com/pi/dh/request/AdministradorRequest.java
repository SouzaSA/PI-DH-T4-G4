package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdministradorRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long administradorId;

	private PessoaRequest pessoa;

	
}
