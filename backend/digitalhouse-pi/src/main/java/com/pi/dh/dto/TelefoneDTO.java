package com.pi.dh.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TelefoneDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long telefoneId;
	private String telefone;
   
}
