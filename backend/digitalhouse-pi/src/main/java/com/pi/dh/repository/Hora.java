package com.pi.dh.repository;

public enum Hora {
	M1("08:00"),
	M2("08:50"),
	M3("10:00"),
	M4("10:50"),
	V1("13:30"),
	V2("14:20"),
	V3("15:30"),
	V4("16:20"),
	N1("19:00"),
	N2("19:50"),
	N3("21:00"),
	N4("21:50");
	
	public String hora;
	
	Hora(String hora){
		this.hora = hora;
	}
	

}
