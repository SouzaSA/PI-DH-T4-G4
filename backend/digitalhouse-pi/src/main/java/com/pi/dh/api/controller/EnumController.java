package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.service.EnumService;

@CrossOrigin
@RestController
@RequestMapping("/enums")
public class EnumController {
	
	@Autowired
	private EnumService enumService;

	@GetMapping("/horarios")
	public List<String> listaHorarios() {
		return enumService.listaHorarios();
	}
	
	@GetMapping("/dias")
	public List<String> listaDias() {
		return enumService.listaDias();
	}
	
	@GetMapping("/avaliacoes")
	public List<String> ListaAvaliacoes() {
		return enumService.listaAvaliacoes();
	}
	
}
