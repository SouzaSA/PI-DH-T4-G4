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

import com.pi.dh.domain.model.Nota;
import com.pi.dh.domain.service.NotaService;

@RestController
@RequestMapping("/notas")
@CrossOrigin
public class NotaController {

	@Autowired
	private NotaService notaService;
	
	@PostMapping
	public void salvar(@RequestBody Nota nota) {
		notaService.salvar(nota);
	}
	
	@GetMapping
	public List<Nota> listar() {
		return notaService.listar();
	}
	
	@GetMapping("/{id}")
	public Nota buscarPorId(@PathVariable Long id) {
		return notaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		notaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Nota nota, @PathVariable Long id) {
		notaService.atualizar(nota, id);
	}
}
