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

import com.pi.dh.domain.model.Pessoa;
import com.pi.dh.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public void salvar(@RequestBody Pessoa pessoa) {
		pessoaService.salvar(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	public Pessoa buscarPorId(@PathVariable Long id) {
		return pessoaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		pessoaService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		pessoaService.atualizar(pessoa, id);
	}
}
