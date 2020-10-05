package com.pi.dh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.dh.domain.model.Telefone;
import com.pi.dh.domain.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
@CrossOrigin
public class TelefoneController {

	@Autowired
	private TelefoneService telefoneService;
	
	@PostMapping
	public void salvar(@RequestBody Telefone telefone) {
		telefoneService.salvar(telefone);
	}
	
	@GetMapping
	public List<Telefone> listar() {
		return telefoneService.listar();
	}
	
	@GetMapping("/{id}")
	public Telefone buscarPorId(@PathVariable Long id) {
		return telefoneService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		telefoneService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Telefone telefone, @PathVariable Long id) {
		telefoneService.atualizar(telefone, id);
	}
}
