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

import com.pi.dh.domain.model.Professor;
import com.pi.dh.domain.repository.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@PostMapping
	public void salvar(@RequestBody Professor professor) {
		professorRepository.save(professor);
	}
	
	@GetMapping
	public List<Professor> listar() {
		return professorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Professor buscar(@PathVariable Long id) {
		return professorRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Professor professor, @PathVariable Long id) {
		Professor prof = professorRepository.findById(id).get();
		
		prof.setPessoa(professor.getPessoa());
		prof.setDepartamento(professor.getDepartamento());
		
		professorRepository.save(prof);
	}
}
