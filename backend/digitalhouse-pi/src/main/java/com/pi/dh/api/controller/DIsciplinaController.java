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
import com.pi.dh.domain.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplinas")
public class DIsciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@PostMapping
	public void salvar(@RequestBody Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}
	
	@GetMapping
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Disciplina buscar(@PathVariable Long id) {
		return disciplinaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		disciplinaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Disciplina disciplina, @PathVariable Long id) {
		Disciplina disc = disciplinaRepository.findById(id).get();
		
		disc.setNome(disciplina.getNome());
		disc.setEmenta(disciplina.getEmenta());
		disc.setCreditos(disciplina.getCreditos());
		disc.setCodigo(disciplina.getCodigo());
		disc.setSemestreIdeal(disciplina.getSemestreIdeal());

		
		disciplinaRepository.save(disc);
	}
}
