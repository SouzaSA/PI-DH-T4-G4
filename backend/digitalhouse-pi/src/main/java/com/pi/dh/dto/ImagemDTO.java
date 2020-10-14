package com.pi.dh.dto;

import java.io.Serializable;
import java.net.URL;

import lombok.Data;

@Data
public class ImagemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeArquivo;
	private String contentType;
	private Long tamanho;
	private URL url;
}