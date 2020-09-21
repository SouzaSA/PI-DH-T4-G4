package com.pi.dh.domain.model;

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
}
