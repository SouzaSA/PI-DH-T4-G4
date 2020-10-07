package com.pi.dh.domain.model.enums;

import lombok.Getter;

@Getter
public enum Obrigatoria {

	Sim(1, "Sim"),
	Não(2, "Não");
	
	private int cod;
	private String description;
	
	private Obrigatoria(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public static Obrigatoria toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Obrigatoria x : Obrigatoria.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida");
	}
}
