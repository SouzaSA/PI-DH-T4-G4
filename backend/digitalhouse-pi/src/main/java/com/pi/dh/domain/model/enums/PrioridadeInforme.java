package com.pi.dh.domain.model.enums;

import lombok.Getter;

@Getter
public enum PrioridadeInforme {

	Baixa(1, "Baixa"),
	Média(2, "Média"),
	Alta(3, "Alta"),
	Urgente(4, "Urgente");
	
	private int cod;
	private String description;
	
	private PrioridadeInforme(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public static PrioridadeInforme toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PrioridadeInforme x : PrioridadeInforme.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida");
	}
}
