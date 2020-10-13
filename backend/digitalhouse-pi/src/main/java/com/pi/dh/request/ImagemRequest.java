package com.pi.dh.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImagemRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@NotNull
	private MultipartFile imagem;
	
}