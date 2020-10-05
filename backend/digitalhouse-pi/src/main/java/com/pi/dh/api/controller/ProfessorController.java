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

import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.service.ProfessorService;

@RestController
@RequestMapping("/professores")
@CrossOrigin
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public void salvar(@RequestBody Professor professor) {
		professorService.salvar(professor);
	}
	
	@GetMapping
	public List<Professor> listar() {
		return professorService.listar();
	}
	
	@GetMapping("/{id}")
	public Professor buscarPorId(@PathVariable Long id) {
		return professorService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		professorService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Professor professor, @PathVariable Long id) {
		professorService.atualizar(professor, id);
	}
}
