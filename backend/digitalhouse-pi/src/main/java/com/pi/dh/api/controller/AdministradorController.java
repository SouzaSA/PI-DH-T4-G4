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

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.domain.repository.AdministradorRepository;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@PostMapping
	public void salvar(@RequestBody Administrador administrador) {
		administradorRepository.save(administrador);
	}
	
	@GetMapping
	public List<Administrador> listar() {
		return administradorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Administrador buscar(@PathVariable Long id) {
		return administradorRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		administradorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Administrador administrador, @PathVariable Long id) {
		Administrador adm = administradorRepository.findById(id).get();
		
		adm.setPessoa(administrador.getPessoa());
		
		administradorRepository.save(adm);
	}
}
