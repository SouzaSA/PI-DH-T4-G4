package com.pi.dh.model;

public enum DiaSemana {
	SEG("segunda"),
	TER("terça"),
	QUA("quarta"),
	QUI("quinta"),
	SEX("sexta"),
	SAB("sábado");
	
	public String dia;
	
	DiaSemana(String dia){
		this.dia = dia;
	}
}
