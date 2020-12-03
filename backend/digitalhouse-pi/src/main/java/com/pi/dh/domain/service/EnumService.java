package com.pi.dh.domain.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pi.dh.domain.model.enums.Avaliacoes;
import com.pi.dh.domain.model.enums.DiaSemana;
import com.pi.dh.domain.model.enums.Hora;

@Service
public class EnumService {

	public List<String> listaHorarios() {
		return  Arrays.asList(Hora.values()).stream().map(value -> value.getHora()).collect(Collectors.toList());
	}
	
	public List<String> listaDias() {
		return  Arrays.asList(DiaSemana.values()).stream().map(value -> value.getDia()).collect(Collectors.toList());
	}
	
	public List<String> listaAvaliacoes() {
		return Arrays.asList(Avaliacoes.values()).stream().map(value -> value.toString()).collect(Collectors.toList());
	}
	
}
