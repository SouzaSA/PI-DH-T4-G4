package com.pi.dh.domain.model.enums;

import lombok.Getter;

@Getter
public enum Departamentos {

	HUM(1, "Humaninades"),
	FIS(2, "Física"),
	MAT(3, "Matemática"),
	QUI(4, "Química");
	
	private int cod;
	private String description;
	
	private Departamentos(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public static Departamentos toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Departamentos x : Departamentos.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Departamento inválido");
	}
	
	
}
