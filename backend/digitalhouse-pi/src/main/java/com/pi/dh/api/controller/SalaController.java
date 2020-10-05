package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.Sala;
import com.pi.dh.domain.service.SalaService;

@RestController
@RequestMapping("/salas")
@CrossOrigin
public class SalaController {

	@Autowired
	private SalaService salaService;
	
	@PostMapping
	public void salvar(@RequestBody Sala sala) {
		salaService.salvar(sala);
	}
	
	@GetMapping
	public List<Sala> listar() {
		return salaService.listar();
	}
	
	@GetMapping("/{id}")
	public Sala buscarPorId(@PathVariable Long id) {
		return salaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		salaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Sala sala, @PathVariable Long id) {
		salaService.atualizar(sala, id);
	}
}
