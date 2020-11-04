package com.pi.dh.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class TelefoneRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long telefoneId;
	private String telefone;

}
