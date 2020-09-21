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

import com.pi.dh.domain.model.Curso;
import com.pi.dh.domain.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping
	public void salvar(@RequestBody Curso curso) {
		cursoRepository.save(curso);
	}
	
	@GetMapping
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Curso buscar(@PathVariable Long id) {
		return cursoRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Curso curso, @PathVariable Long id) {
		Curso cur = cursoRepository.findById(id).get();
		
		cur.setNome(curso.getNome());
		cur.setProfessor(curso.getProfessor());

		
		cursoRepository.save(cur);
	}
}
