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

import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.repository.TelefoneRepository;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@PostMapping
	public void salvar(@RequestBody Telefone telefone) {
		telefoneRepository.save(telefone);
	}
	
	@GetMapping
	public List<Telefone> listar() {
		return telefoneRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Telefone buscar(@PathVariable Long id) {
		return telefoneRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		telefoneRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Telefone telefone, @PathVariable Long id) {
		Telefone tel = telefoneRepository.findById(id).get();
		
		tel.setTelefone(telefone.getTelefone());

		
		telefoneRepository.save(tel);
	}
}
