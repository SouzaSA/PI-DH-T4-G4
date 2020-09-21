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

import com.pi.dh.domain.model.DisciplinaOferecida;
import com.pi.dh.domain.repository.DisciplinaOferecidaRepository;

@RestController
@RequestMapping("/disciplinaOferecidas")
public class DisciplinaOferecidaController {

	@Autowired
	private DisciplinaOferecidaRepository disciplinaOferecidaRepository;
	
	@PostMapping
	public void salvar(@RequestBody DisciplinaOferecida disciplinaOferecida) {
		disciplinaOferecidaRepository.save(disciplinaOferecida);
	}
	
	@GetMapping
	public List<DisciplinaOferecida> listar() {
		return disciplinaOferecidaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public DisciplinaOferecida buscar(@PathVariable Long id) {
		return disciplinaOferecidaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		disciplinaOferecidaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody DisciplinaOferecida disciplinaOferecida, @PathVariable Long id) {
		DisciplinaOferecida discO = disciplinaOferecidaRepository.findById(id).get();
		
		discO.setHorario(disciplinaOferecida.getHorario());
		discO.setDiaSemana(disciplinaOferecida.getDiaSemana());
		discO.setSemestre(disciplinaOferecida.getSemestre());
		discO.setAno(disciplinaOferecida.getAno());
		discO.setTurma(disciplinaOferecida.getTurma());
		discO.setProfessor(disciplinaOferecida.getProfessor());
		discO.setDisciplina(disciplinaOferecida.getDisciplina());
		discO.setSala(disciplinaOferecida.getSala());



		
		disciplinaOferecidaRepository.save(discO);
	}
}
