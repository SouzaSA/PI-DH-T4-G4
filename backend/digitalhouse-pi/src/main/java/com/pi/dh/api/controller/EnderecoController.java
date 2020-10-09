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

import com.pi.dh.domain.model.Endereco;
import com.pi.dh.domain.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public void salvar(@RequestBody Endereco endereco) {
		enderecoService.salvar(endereco);
	}
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecoService.listar();
	}
	
	@GetMapping("/{id}")
	public Endereco buscarPorId(@PathVariable Integer id) {
		return enderecoService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		enderecoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Endereco endereco, @PathVariable Integer id) {
		enderecoService.atualizar(endereco, id);
	}
}
