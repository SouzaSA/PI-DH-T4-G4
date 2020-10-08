package com.pi.dh.request;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImagemRequest {
	
	@NotNull
	private MultipartFile imagem;
	
}