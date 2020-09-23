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
import com.pi.dh.domain.service.RequereService;

@RestController
@RequestMapping("/requeres")
public class RequereController {

	@Autowired
	private RequereService requereService;
	
	@PostMapping
	public void salvar(@RequestBody Requere requere) {
		requereService.salvar(requere);
	}
	
	@GetMapping
	public List<Requere> listar() {
		return requereService.listar();
	}
	
	@GetMapping("/{id}")
	public Requere buscarPorId(@PathVariable Long id) {
		return requereService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		requereService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Requere requere, @PathVariable Long id) {
		requereService.atualizar(requere, id);
	}
}
