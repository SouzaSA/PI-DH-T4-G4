package com.pi.dh.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.pi.dh.validation.FileSize;

import lombok.Data;

@Data
public class FotoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@FileSize(max = "1000000KB")
	private MultipartFile foto;
	
}
