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

import com.pi.dh.domain.model.Sala;
import com.pi.dh.domain.repository.SalaRepository;

@RestController
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	private SalaRepository salaRepository;
	
	@PostMapping
	public void salvar(@RequestBody Sala sala) {
		salaRepository.save(sala);
	}
	
	@GetMapping
	public List<Sala> listar() {
		return salaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Sala buscar(@PathVariable Long id) {
		return salaRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		salaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Sala sala, @PathVariable Long id) {
		Sala sl = salaRepository.findById(id).get();
		sl.setAndar(sala.getAndar());
		sl.setCapacidade(sala.getCapacidade());
		sl.setDepartamento(sala.getDepartamento());
		sl.setNumero(sala.getNumero());
		
		salaRepository.save(sl);
	}
}
