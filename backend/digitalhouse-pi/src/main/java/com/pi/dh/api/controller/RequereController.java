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

import com.pi.dh.domain.model.Requere;
import com.pi.dh.domain.repository.RequereRepository;

@RestController
@RequestMapping("/requeres")
public class RequereController {

	@Autowired
	private RequereRepository requereRepository;
	
	@PostMapping
	public void salvar(@RequestBody Requere requere) {
		requereRepository.save(requere);
	}
	
	@GetMapping
	public List<Requere> listar() {
		return requereRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Requere buscar(@PathVariable Long id) {
		return requereRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		requereRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Requere requere, @PathVariable Long id) {
		Requere req = requereRepository.findById(id).get();
		
		req.setDisciplina(requere.getDisciplina());
		req.setRequerida(requere.getRequerida());

		
		requereRepository.save(req);
	}
}
