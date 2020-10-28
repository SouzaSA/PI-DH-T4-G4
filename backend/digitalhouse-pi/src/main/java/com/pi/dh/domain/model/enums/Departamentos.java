package com.pi.dh.domain.model.enums;

import lombok.Getter;

@Getter
public enum Departamentos {

	Dept1(1, "Humaninades"),
	Dept2(2, "Física"),
	Dept3(3, "Matemática"),
	Dept4(4, "Química");
	
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
