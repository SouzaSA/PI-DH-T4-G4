package com.pi.dh.domain.model.enums;

public enum DiaSemana {
	SEG("segunda"),
	TER("terça"),
	QUA("quarta"),
	QUI("quinta"),
	SEX("sexta"),
	SAB("sábado");
	
	private String dia;
	
	private DiaSemana(String dia){
		this.dia = dia;
	}
	
	public String getDia() {
		return dia;
	}
	
	public static DiaSemana toEnum(String dia) {
		if (dia.equals(null) || dia.equals("")) {
			return null;
		}
		
		for (DiaSemana x : DiaSemana.values()) {
			if (dia.equals(x.getDia())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Dia da semana inválido");
	}
}
