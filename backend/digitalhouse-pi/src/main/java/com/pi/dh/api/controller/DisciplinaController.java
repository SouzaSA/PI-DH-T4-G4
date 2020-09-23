package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.Disciplina;
import com.pi.dh.domain.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping
	public void salvar(@RequestBody Disciplina disciplina) {
		disciplinaService.salvar(disciplina);
	}
	
	@GetMapping
	public List<Disciplina> listar() {
		return disciplinaService.listar();
	}
	
	@GetMapping("/{id}")
	public Disciplina buscarPorId(@PathVariable Long id) {
		return disciplinaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		disciplinaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Disciplina disciplina, @PathVariable Long id) {
		disciplinaService.atualizar(disciplina, id);
	}
}
