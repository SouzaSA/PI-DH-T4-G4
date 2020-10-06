package com.pi.dh.request;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.pi.dh.validation.FileSize;

import lombok.Data;

@Data
public class FotoRequest {

	@NotNull
	@FileSize(max = "1000000KB")
	private MultipartFile foto;
	
}
