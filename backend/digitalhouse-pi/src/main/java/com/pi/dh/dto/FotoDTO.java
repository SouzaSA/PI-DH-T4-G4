package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FotoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nomeArquivo;
	private String contentType;
	private Long tamanho;
}
