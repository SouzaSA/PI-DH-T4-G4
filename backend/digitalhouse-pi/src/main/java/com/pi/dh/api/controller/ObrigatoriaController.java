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

import com.pi.dh.domain.model.Obrigatoria;
import com.pi.dh.domain.repository.ObrigatoriaRepository;

@RestController
@RequestMapping("/obrigatorias")
public class ObrigatoriaController {

	@Autowired
	private ObrigatoriaRepository obrigatoriaRepository;
	
	@PostMapping
	public void salvar(@RequestBody Obrigatoria obrigatoria) {
		obrigatoriaRepository.save(obrigatoria);
	}
	
	@GetMapping
	public List<Obrigatoria> listar() {
		return obrigatoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Obrigatoria buscar(@PathVariable Long id) {
		return obrigatoriaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		obrigatoriaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Obrigatoria obrigatoria, @PathVariable Long id) {
		Obrigatoria obr = obrigatoriaRepository.findById(id).get();
		
		obr.setCurso(obrigatoria.getCurso());
		obr.setDisciplina(obrigatoria.getDisciplina());

		
		obrigatoriaRepository.save(obr);
	}
}
