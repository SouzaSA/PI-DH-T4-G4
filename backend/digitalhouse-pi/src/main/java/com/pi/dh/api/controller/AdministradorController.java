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

import com.pi.dh.domain.model.Administrador;
import com.pi.dh.domain.service.AdministradorService;
import com.pi.dh.domain.service.PessoaService;

@RestController
@RequestMapping("/administradores")
@CrossOrigin
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public void salvar(@RequestBody Administrador administrador) {
		pessoaService.salvar(administrador.getPessoa());
		administradorService.salvar(administrador);
	}
	
	@GetMapping
	public List<Administrador> listar() {
		return administradorService.listar();
	}
	
	@GetMapping("/{id}")
	public Administrador buscarPorId(@PathVariable Long id) {
		return administradorService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		administradorService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Administrador administrador, @PathVariable Long id) {
		administradorService.atualizar(administrador, id);
	}
}
