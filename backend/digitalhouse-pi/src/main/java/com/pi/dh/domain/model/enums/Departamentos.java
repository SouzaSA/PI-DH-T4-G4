package com.pi.dh.domain.model.enums;

import lombok.Getter;

@Getter
public enum Departamentos {

	Dept1(1, "Dept1"),
	Depr2(2, "Dept2"),
	Dept3(3, "Dept3"),
	Dept4(4, "Dept4");
	
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
